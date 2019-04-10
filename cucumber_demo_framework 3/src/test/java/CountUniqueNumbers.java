import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountUniqueNumbers {

    public int countUniqueValues(int arr[] ) {
        ArrayList<Integer> uniqueList = new ArrayList();
        uniqueList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!uniqueList.contains(arr[i])) {
                uniqueList.add(arr[i]);
            }
        }
        return uniqueList.size();
    }

        public int[] sumZero(int arr[]) {
            int pair[] = new int[2];

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] + arr[j] == 0) {
                        pair[0] = arr[i];
                        pair[1] = arr[j];
                        return pair;
                    }
                }
            }
                return null;
        }

    @Test
    public void testCountForrThree() {
        int arr[] = {1,1,1,2,2,2,3,3};

        Assert.assertEquals(countUniqueValues(arr), 3);
    }

    @Test
    public void testEmptyCount() {

        int arr[] = {};

        Assert.assertEquals(countUniqueValues(arr), 0);
    }

        @Test
        public  void testPairOfThree() {
            int arr[] = {-3, -2, -1, 0, 1, 2, 3};

            int pair[] = sumZero(arr);

            if (pair != null) {
                int result = pair[0] + pair[1];
                Assert.assertEquals(result, 0);
            }
        }

        @Test
        public void testNull() {
        int arr[] = {1,2,3};

        Assert.assertNull(sumZero(arr));
        }


    }


