# Java-Quaternion

Este proyecto es una implementación de la clase `Quaternion` en Java, que representa un cuaternión. Un cuaternión es un tipo de número complejo extendido que se utiliza en matemáticas y gráficos computacionales para representar rotaciones en el espacio tridimensional.

## Uso

Puedes utilizar la clase `Quaternion` en tu proyecto de Java para realizar operaciones con cuaterniones, como la creación de cuaterniones, multiplicación, conjugación, rotación de puntos y más.

Aquí hay algunos ejemplos de cómo puedes utilizar la clase `Quaternion`:

```java
// Crear un cuaternión
Quaternion q = new Quaternion(1.0f, 2.0f, 3.0f, 4.0f);

// Obtener el ángulo y el eje de rotación del cuaternión
float angle = q.getAngle();
float[] axis = q.getAxis();

// Multiplicar dos cuaterniones
Quaternion q1 = new Quaternion(1.0f, 2.0f, 3.0f, 4.0f);
Quaternion q2 = new Quaternion(0.5f, 0.5f, 0.5f, 0.5f);
Quaternion result = q1.mult(q2);

// Rotar un punto utilizando un cuaternión
float[] point = {1.0f, 0.0f, 0.0f};
float[] rotatedPoint = q.rotatePoint(point);
```

## Métodos principales

A continuación se presentan algunos de los métodos principales de la clase `Quaternion`:

- `Quaternion(float real, float i, float j, float k)`: Constructor que crea un cuaternión con los componentes especificados.
- `void set(float angle, float[] axis)`: Establece el cuaternión utilizando un ángulo y un eje de rotación.
- `Quaternion conjugate()`: Calcula el conjugado del cuaternión actual.
- `Quaternion mult(Quaternion q)`: Multiplica el cuaternión actual por otro cuaternión.
- `float[] rotatePoint(float[] point)`: Rota un punto utilizando el cuaternión actual.
- `float getAngle()`: Obtiene el ángulo de rotación del cuaternión.
- `float[] getAxis()`: Obtiene el eje de rotación del cuaternión.
- `float norm()`: Calcula la norma (longitud) del cuaternión.
- `Quaternion normalize()`: Normaliza el cuaternión.

## Contribución

Si deseas contribuir a este proyecto, puedes hacer lo siguiente:

- Realizar mejoras en la implementación existente.
- Añadir nuevos métodos o funcionalidades a la clase `Quaternion`.
- Corregir errores o problemas.

Siéntete libre de realizar un fork de este proyecto, hacer tus modificaciones y enviar una solicitud de extracción con tus cambios propuestos.

## Licencia

Este proyecto se encuentra bajo la licencia [MIT](https://opensource.org/licenses/MIT), lo que significa que puedes utilizarlo de forma gratuita, modificarlo y distribuirlo según tus necesidades. Ver el archivo [LICENSE](./LICENSE) para más detalles.
