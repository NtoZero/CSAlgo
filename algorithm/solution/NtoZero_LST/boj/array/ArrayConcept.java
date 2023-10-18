package algorithm.solution.NtoZero_LST.boj.array;

import java.util.Arrays;

public class ArrayConcept {
    static int[] arrSrc = {10, 50, 40, 30, 70, 20};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertDeepCopy(3, 60, arrSrc)));
        System.out.println(Arrays.toString(arrSrc));
        insertShallowCopy(3, 60, arrSrc);
        System.out.println(Arrays.toString(arrSrc));
        eraseShallowCopy(3, arrSrc);
        System.out.println(Arrays.toString(arrSrc));
    }

    // array 삽입, insert (깊은 복사)
    static int[] insertDeepCopy(int idx, int num, int[] arr) {
        int length = arr.length;
        if(idx<=0 || idx>length) throw new RuntimeException("idx is inCorrect!");

        int[] newArr = new int[arr.length+1];
        System.arraycopy(arr, 0,newArr, 0, idx);
        newArr[idx] = num;
        System.arraycopy(arr, idx, newArr, idx+1, length-idx);

        return newArr;
    }

    // array 삽입, insert (얕은 복사)
    static void insertShallowCopy(int idx, int num, int[] arr) {
        int length = arr.length;
        if(idx<=0 || idx>length) throw new RuntimeException("idx is inCorrect!");
        int[] newArr = new int[length+1];
        for(int i=0; i<idx; i++) {
            newArr[i] = arr[i];
        }
        newArr[idx] = num;
        for(int i=idx+1; i<length+1; i++) {
            newArr[i] = arr[i-1];
        }
        arrSrc = newArr;
    }

    // array 요소 삭제, erase (얕은 복사)
    static void eraseShallowCopy(int idx, int[] arr) {
        int length = arr.length;
        if(idx<=0 || idx>length) throw new RuntimeException("idx is inCorrect!");
        int[] newArr = new int[length-1];

        for(int i=0; i<idx; i++) {
            newArr[i] = arr[i];
        }

        for(int i=idx; i<length-1; i++) {
            newArr[i] = arr[i+1];
        }
        arrSrc = newArr;
    }

}
