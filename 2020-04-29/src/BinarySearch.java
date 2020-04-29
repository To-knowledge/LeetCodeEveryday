import Utils.MountainArray;

public class BinarySearch {

}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        //使用二分法
        //1、寻找山脉的峰值点
        int PeakIndex = 0;
        PeakIndex = findInMountainArrayPeak(mountainArr, 0, mountainArr.length());
        //2、左边二分查找，然后右边二分查找
        //2.1、从左边开始找
        int res = 0;
        if(target >= mountainArr.get(0) && target < mountainArr.get(PeakIndex))
            res = findInMountainArrayLeft(target, mountainArr, 0, PeakIndex);
        if(mountainArr.get(res) == target) return res;
            //2.1、从右边开始找
        else if(target >= mountainArr.get(mountainArr.length() - 1) && target <= mountainArr.get(PeakIndex))
            res = findInMountainArrayRight(target, mountainArr, PeakIndex, mountainArr.length());
        if(mountainArr.get(res) == target) return res;

        return -1;
    }

    private int findInMountainArrayPeak(MountainArray mountainArr, int begin, int end){
        //递归结束条件
        if(end - begin < 2) return begin;

        int mid = begin + ((end - begin) >> 1);
        if(mountainArr.get(mid) > mountainArr.get(mid - 1)){
            return findInMountainArrayPeak(mountainArr, mid, end);
        }
        else
            return findInMountainArrayPeak(mountainArr, begin, mid);
    }

    private int findInMountainArrayLeft(int target, MountainArray mountainArr, int begin, int end){
        //递归结束条件
        if(end - begin < 2) return begin;
        int mid = begin + ((end - begin) >> 1);
        if(mountainArr.get(mid) > target)
            return findInMountainArrayLeft(target, mountainArr, begin, mid);
        else
            return findInMountainArrayLeft(target, mountainArr, mid, end);
    }

    private int findInMountainArrayRight(int target, MountainArray mountainArr, int begin, int end){
        if(end - begin < 2) return begin;
        int mid = begin + ((end - begin) >> 1);
        if(mountainArr.get(mid) >= target)
            return findInMountainArrayRight(target, mountainArr, mid, end);
        else
            return findInMountainArrayRight(target, mountainArr, begin, mid);
    }
}
