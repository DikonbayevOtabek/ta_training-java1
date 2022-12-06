package com.epam.rd.autotasks;



class Spiral {
    static int[][] spiral(int rows, int columns) {
        int [][] arr = new int[rows][columns];


        int index = 0, ind = 0, j = 0, i = 0;
        while(index <= rows * columns){
            if (i == ind){
                for (j = ind; j < columns - ind; ++j){
                    if (index == rows * columns)
                        break;
                    ++index;
                    arr[i][j] = index;

                }
                ++ind;
                --j;
            }
            if (j == columns - ind){
                for (i = ind; i < rows - ind + 1; ++i){
                    if (index == rows * columns)
                        break;
                    ++index;
                    arr[i][j] = index;

                }
                --i;
            }
            if (i == rows -ind){
                for ( j = columns - ind - 1; j >= ind - 1; --j){
                    if (index == rows * columns)
                        break;
                    ++index;
                    arr[i][j] = index;
                }
                ++j;
            }
            if (j == ind - 1){
                for (i = rows - ind - 1; i >= ind; --i){
                    if (index == rows * columns)
                        break;
                    ++index;
                    arr[i][j] = index;
                }
                ++i;
            }
            if (index == rows * columns)
                break;
        }
        return arr;
    }


}
