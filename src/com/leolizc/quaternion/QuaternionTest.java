package com.leolizc.quaternion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuaternionTest {

    @Test
    public void testSetAndGet() {
        Quaternion quaternion = new Quaternion(1.0f, 2.0f, 3.0f, 4.0f);

        assertEquals(1.0f, quaternion.real);
        assertEquals(2.0f, quaternion.i);
        assertEquals(3.0f, quaternion.j);
        assertEquals(4.0f, quaternion.k);
    }

    @Test
    public void testSetWithInvalidAxis() {
        float[] invalidAxis = {1.0f, 2.0f}; // Axis with incorrect length
        Quaternion quaternion = new Quaternion();

        assertThrows(IllegalArgumentException.class, () -> quaternion.set(45.0f, invalidAxis));
    }

    @Test
    public void testConjugate() {
        Quaternion quaternion = new Quaternion(1.0f, 2.0f, 3.0f, 4.0f);
        Quaternion conjugate = quaternion.getConjugate();

        assertEquals(1.0f, conjugate.real);
        assertEquals(-2.0f, conjugate.i);
        assertEquals(-3.0f, conjugate.j);
        assertEquals(-4.0f, conjugate.k);
    }

    @Test
    public void testMult() {
        Quaternion q1 = new Quaternion(1.0f, 2.0f, 3.0f, 4.0f);
        Quaternion q2 = new Quaternion(2.0f, 3.0f, 4.0f, 5.0f);
        Quaternion result = q1.mult(q2);

        // Verify that q1 is modified and returned as the result
        assertSame(q1, result);

        // Verify the updated values
        assertEquals(-36.0f, q1.real);
        assertEquals(6.0f, q1.i);
        assertEquals(12.0f, q1.j);
        assertEquals(12.0f, q1.k);
    }

    @Test
    public void testRotatePoint() {
        Quaternion quaternion = new Quaternion((float)Math.PI/6f, new float[]{0f, 0.0f, 1f});
        float[] point = {0.6f, .8f, 0f};
        float[] rotatedPoint = quaternion.rotatePoint(point);

        // Verify the rotated point values
        assertEquals(0f, rotatedPoint[2]);
        assertTrue(Math.abs(rotatedPoint[0] - 0.11962f) < 0.001);
        assertTrue(Math.abs(rotatedPoint[1] - 0.99282f) < 0.001);
    }
}