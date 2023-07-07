package com.leolizc.quaternion;

public class Quaternion {
    protected float real, i, j, k;

    public Quaternion(float real, float i, float j, float k){
        this.real = real;
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public Quaternion(){
        real=i=j=k=0;
    }

    public Quaternion(float angle, float[] axis){
        set(angle, axis);
    }

    public void set(float angle, float[] axis){
        if (axis.length != 3){
            throw new IllegalArgumentException("The axis should be 3Dimensional");
        }

        float halfAngle = angle/2f;
        this.real = (float) Math.cos(halfAngle);
        double sin = Math.sin(halfAngle);

        this.i = (float) (sin*axis[0]);
        this.j = (float) (sin*axis[1]);
        this.k = (float) (sin*axis[2]);
    }

    public Quaternion set(Quaternion q){

        this.real = q.real;
        this.i = q.i;
        this.j = q.j;
        this.k = q.k;

        return this;
    }

    public Quaternion copy(){
        return new Quaternion(real,i,j,k);
    }

    public Quaternion conjugate(){

        return set(getConjugate());
    }

    public Quaternion getConjugate(){
        return new Quaternion(real,-i,-j,-k);
    }

    public Quaternion mult(Quaternion q){

        float real = this.real*q.real - dotProd(q);
        float [] cross = crossProd(q);

        this.i = cross[0] + q.i*this.real + q.real*this.i;
        this.j = cross[1] + q.j*this.real + q.real*this.j;
        this.k = cross[2] + q.k*this.real + q.real*this.k;
        this.real = real;

        return this;
    }

    public float[] rotatePoint(float[] point){

        if(point.length != 3){
            throw new IllegalArgumentException("The axis should be 3Dimensional");
        }

        Quaternion copy = this.copy(), conjugated = this.getConjugate(), qPoint = new Quaternion(0, point[0], point[1], point[2]);
        copy = copy.mult(qPoint);
        copy = copy.mult(conjugated);

        return new float[]{copy.i,copy.j,copy.k};
    }

    private float dotProd(Quaternion q){

        return this.i*q.i+this.j*q.j+this.k*q.k;
    }

    private float[] crossProd(Quaternion q){

        return new float[]{
                this.j*q.k - this.k*q.j,
                -this.i*q.k+this.k*q.i,
                this.i*q.j-this.j*q.i
        };
    }
}
