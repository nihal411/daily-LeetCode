class Solution{
    int[]tree;
    void update(int node,int l,int r,int idx){
        if(l==r){
            tree[node]++;
            return;
        }
        int mid=(l+r)/2;
        if(idx<=mid)
            update(2*node,l,mid,idx);
        else
            update(2*node+1,mid+1,r,idx);
        tree[node]=tree[2*node]+tree[2*node+1];
    }

    int query(int node,int l,int r,int ql,int qr){
        if(qr<l||r<ql)
            return 0;
        if(ql<=l&&r<=qr)
            return tree[node];
        int mid=(l+r)/2;
        return query(2*node,l,mid,ql,qr)+query(2*node+1,mid+1,r,ql,qr);
    }

    public List<Integer> countSmaller(int[]nums){
        int n=nums.length;
        int[]a=nums.clone();
        Arrays.sort(a);

        tree=new int[4*n];
        List<Integer>ans=new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            int idx=Arrays.binarySearch(a,nums[i]);
            int count=query(1,0,n-1,0,idx-1);
            ans.add(count);
            update(1,0,n-1,idx);
        }

        Collections.reverse(ans);
        return ans;
    }
}