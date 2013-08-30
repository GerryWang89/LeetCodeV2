public class Solution {

	public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length <= B.length){
            return solve(A,0,A.length - 1,B,0,B.length - 1);
        }else{
            return solve(B,0,B.length - 1,A,0,A.length - 1);
        }
    }
    
    public double solve(int[] A, int leftA, int rightA, int[] B, int leftB, int rightB){
    	if(rightA - leftA == 0){
    		int[] tmp = new int[2 + rightB - leftB];
    		for(int i = 0; i < rightB - leftB + 1; i++){
    			tmp[i] = B[leftB+i];
    		}
    		tmp[tmp.length - 1] = A[leftA];
    		Arrays.sort(tmp);
    		return getMedian(tmp, 0, tmp.length - 1);
    	}
    	if(rightA - leftA == 1){
    		int[] tmp = new int[3 + rightB - leftB];
    		for(int i = 0; i < rightB - leftB + 1; i++){
    			tmp[i] = B[leftB+i];
    		}
    		tmp[tmp.length - 2] = A[leftA];
    		tmp[tmp.length - 1] = A[rightA];
    		Arrays.sort(tmp);
    		return getMedian(tmp, 0, tmp.length - 1);
    	}
        if(leftA > rightA){
            return getMedian(B,leftB,rightB);
        }
        double medianA = getMedian(A,leftA,rightA); 
        double medianB = getMedian(B,leftB,rightB);
        if(medianA < medianB){
        	int len = 0;
        	if ((rightA - leftA) % 2 == 0 && (rightB - leftB) % 2 == 0){
        		len = Math.min((leftA+rightA)/2 - leftA,rightB - (leftB + rightB)/2);
        	}else if ((rightA - leftA) % 2 == 1 && (rightB - leftB) % 2 == 1){
        		len = Math.min((leftA+rightA)/2 - leftA,rightB - (leftB + rightB)/2 - 1);
        	}else{
        		len = Math.min((leftA+rightA)/2 - leftA,rightB - (leftB + rightB)/2);
        	}
        	return solve(A,leftA + len, rightA, B, leftB, rightB - len);
        }else if(medianA > medianB){
        	int len = 0;
        	if ((rightA - leftA) % 2 == 0 && (rightB - leftB) % 2 == 0){
        		len = Math.min(rightA - (leftA+rightA)/2,(leftB + rightB)/2 - leftB);
        	}else if ((rightA - leftA) % 2 == 1 && (rightB - leftB) % 2 == 1){
        		len = Math.min(rightA - (leftA+rightA)/2 - 1,(leftB + rightB)/2 - leftB);
        	}else{
        		len = Math.min(rightA - (leftA+rightA)/2,(leftB + rightB)/2 - leftB + 1);
        	}
        	return solve(A,leftA, rightA-len, B, leftB + len, rightB);
        }else{
            return medianA;
        }
    }
    
    public double getMedian(int[] A, int leftA, int rightA){
    	if(leftA == rightA){
    		return A[leftA];
    	}
        if((rightA - leftA) % 2 == 1){
            return (A[(leftA + rightA)/2] + A[(leftA + rightA)/2 + 1]) * 1.0/2;
        }else{
            return A[(leftA + rightA)/2] * 1.0;
        }
    }
}