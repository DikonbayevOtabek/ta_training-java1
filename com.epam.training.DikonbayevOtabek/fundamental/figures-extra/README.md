# Figures. Extra Challenge

The purpose of this exercise is to train you to work with classes, methods and inheritance.

Estimated workload of this exercise is _60 min_.

### Description
Please, make [`Triangle`](src/main/java/com/epam/rd/autotasks/figures/Triangle.java),
[`Quadrilateral`](src/main/java/com/epam/rd/autotasks/figures/Quadrilateral.java),
[`Circle`](src/main/java/com/epam/rd/autotasks/figures/Circle.java) classes
extend [`Figure`](src/main/java/com/epam/rd/autotasks/figures/Figure.java) abstract class.

Implement methods in `Triangle`, `Quadrilateral`, `Circle`:

1. Constructors with following parameters:
   * `Triangle` - three vertices (points) as parameters.
   * `Quadrilateral` - four vertices (points) as parameters.
   * `Circle` - point of the center and double value of the radius.

     Ensure figures are not degenerative.\
     All of them must have non-zero area.\
     Quadrilateral is also must be convex.\
     If a figure is not good, throw an IllegalArgumentException.\
     *Note*: A non-degenerative convex quadrilateral is divided into four non-degenerative triangles by its diagonals.
     *Note*: double calculations are not completely accurate, use *error delta*, where applies.
1. `public Point centroid()`\
  Return the centroid of the figure.\
  Centroid refers to center of mass of the plain figure, not the baricenter.\
  In other words it should be *"area centroid"*.
1. `public boolean isTheSame(Figure figure)`\
  Two figures are considered to be the same only:
   * if they have the same type
   * and if they coincide (e.g. have same vertices).
     
     *Note*: order of the vertices have not to be the same.\
     *Note*: double calculations are not completely accurate, use *error delta*, where applies.

  *Note for curious: it is almost like `equals()` but it is not. Method `equals` requires consistent behavior alongside `hashCode()` and it is quite complicated to establish in terms of approximate equality like in this exercise*

[`Point`](src/main/java/com/epam/rd/autotasks/figures/Point.java) class is already there.

You may use `main` method of `Figure` class to tryout your code.

Hints:
* [Degeneracy reference](https://en.wikipedia.org/wiki/Degeneracy_(mathematics))
* [Convex quadrilateral reference](https://en.wikipedia.org/wiki/Quadrilateral#Convex_quadrilaterals)
* [Circle centroid reference](https://www.engineeringintro.com/mechanics-of-structures/centre-of-gravity/centroid-of-circle/)
* [Triangle centroid reference](https://en.wikipedia.org/wiki/Centroid#Of_a_triangle)
* [Quadrilateral centroid reference](https://en.wikipedia.org/wiki/Quadrilateral#Remarkable_points_and_lines_in_a_convex_quadrilateral)
* [Quadrilateral centroid reference 2](https://sites.math.washington.edu/~king/java/gsp/center-mass-quad.html)


// Java program to implement
// the above approach
class GFG
{

// Utility function to find cross product
// of two vectors
static int CrossProduct(int A[][])
{
// Stores coefficient of X
// direction of vector A[1]A[0]
int X1 = (A[1][0] - A[0][0]);

	// Stores coefficient of Y
	// direction of vector A[1]A[0]
	int Y1 = (A[1][1] - A[0][1]);

	// Stores coefficient of X
	// direction of vector A[2]A[0]
	int X2 = (A[2][0] - A[0][0]);

	// Stores coefficient of Y
	// direction of vector A[2]A[0]
	int Y2 = (A[2][1] - A[0][1]);

	// Return cross product
	return (X1 * Y2 - Y1 * X2);
}

// Function to check if the polygon is
// convex polygon or not
static boolean isConvex(int points[][])
{
// Stores count of
// edges in polygon
int N = points.length;

	// Stores direction of cross product
	// of previous traversed edges
	int prev = 0;

	// Stores direction of cross product
	// of current traversed edges
	int curr = 0;

	// Traverse the array
	for (int i = 0; i < N; i++) {

		// Stores three adjacent edges
		// of the polygon
		int temp[][]= { points[i],
				points[(i + 1) % N],
				points[(i + 2) % N] };

		// Update curr
		curr = CrossProduct(temp);

		// If curr is not equal to 0
		if (curr != 0) {

			// If direction of cross product of
			// all adjacent edges are not same
			if (curr * prev < 0) {
				return false;
			}
			else {
				// Update curr
				prev = curr;
			}
		}
	}
	return true;
}

// Driver code
public static void main(String [] args)
{
int points[][] = { { 0, 0 }, { 0, 1 },
{ 1, 1 }, { 1, 0 } };

	if (isConvex(points))
	{
		System.out.println("Yes");
	}
	else
	{
		System.out.println("No");
	}
}
}

// This code is contributed by chitranayal