直接插入排序:
void insertSort(int a[],int n)
{
	for(int i=2;i<=n;i++)
	{
		a[0]=a[i];
		for(int j=i-1;j--;j>=1)
		{
			if(a[0]<a[j]){
				a[j+1]=a[j];
			}
			else
			{
				a[j+1]=a[0];
				break;
			}
		}
	}
}
折半查找排序：
void insertSort(int a[],int n)
{
	for(int i=2;i<=n;i++)
	{
		a[0]=a[i];
		int low=1;
		int high=i-1;
		while(low<high)
		{
			int mid=(low+high)/2
			if(a[mid]>a[0]) high=mid-1;
			else low=mid+1;
		}
		for(int j=i-1;j>=high+1;j--)
			a[j]=a[j-1];
		a[high+1]=a[0];
	}
}
void ShellSort(int a[],int n)
{
	for(int gap=n/2;gap>1;gap=gap/2)
	{
		for(int i=gap+1;i<=n;i++)
		{
			if(a[i]<a[i-gap]){
				a[0]=a[i];
				for(int j=i-gap;j>=1;&&a[0]<a[j];j=j-gap)
				{
					a[j+gap]=a[j];
				}
				a[j+gap]=a[0];
			}
		}
	}
}
冒泡排序：
void BubbleSort(int a[],int n)
{
	for(int i=1;i<n;i++)
	{
		int flag=0;
		for(int j=1;j<n-i;j++)
		{
			if(a[j]>a[j+1]) {swap(a[j],a[j+1]);flag=1;}
		}
		if(flag==0) break;
	}
}
快速排序：
void QuickSort(int a[],int n,int left,int right)
{
	if(left>=right) return ;
	int low=left,high=right;
	int key=a[low]
	while(low<high)
	{
		while(low<high&&a[high]>=key) high--;
		if(low<high&&a[high]<key) a[low]=a[high];
		while(low<high&&a[low]<key) low++;
		if(low<high&&a[low]>key) a[high]=a[low];
	}
	a[high+1]=key;
	QuickSort(a,n,left,high-1);
	QuickSort(a,n,high+1,right);
}
堆排序：
#include <iostream>
#include<algorithm>
using namespace std;

void HeapAdjust(int *a,int i,int size)  //调整堆 
{
    int lchild=2*i;       //i的左孩子节点序号 
    int rchild=2*i+1;     //i的右孩子节点序号 
    int max=i;            //临时变量 
    if(i<=size/2)          //如果i不是叶节点就不用进行调整 
    {
        if(lchild<=size&&a[lchild]>a[max])
        {
            max=lchild;
        }    
        if(rchild<=size&&a[rchild]>a[max])
        {
            max=rchild;
        }
        if(max!=i)
        {
            swap(a[i],a[max]);
            HeapAdjust(a,max,size);    //避免调整之后以max为父节点的子树不是堆 
        }
    }        
}

void BuildHeap(int *a,int size)    //建立堆 
{
    int i;
    for(i=size/2;i>=1;i--)    //非叶节点最大序号值为size/2 
    {
        HeapAdjust(a,i,size);    
    }    
} 

void HeapSort(int *a,int size)    //堆排序 
{
    int i;
    BuildHeap(a,size);
    for(i=size;i>=1;i--)
    {
        //cout<<a[1]<<" ";
        swap(a[1],a[i]);           //交换堆顶和最后一个元素，即每次将剩余元素中的最大者放到最后面 
          //BuildHeap(a,i-1);        //将余下元素重新建立为大顶堆 
          HeapAdjust(a,1,i-1);      //重新调整堆顶节点成为大顶堆
    }
} 

int main(int argc, char *argv[])
{
     //int a[]={0,16,20,3,11,17,8};
    int a[100];
    int size;
    while(scanf("%d",&size)==1&&size>0)
    {
        int i;
        for(i=1;i<=size;i++)
            cin>>a[i];
        HeapSort(a,size);
        for(i=1;i<=size;i++)
            cout<<a[i]<<" ";
        cout<<endl;
    }
    return 0;
}

简单选择排序：
void SimpleChooseSort(int a[],int n){
	for(int i=1;i<=n;i++){
		int min=a[i];
		int minj=i;
		for(int j=i+1;j<=n;j++){
			if(a[j]<min) {min=a[j];minj=j;}
		}
		swap(a[minj],a[i]);
	}
}

归并排序:
void getParition(int a[],int low,int high){
	if(low < high){
		int mid=(low+high)/2;
		getParition(a,low,mid);
		getParition(a,mid+1,high);
		guibing(a,low,mid,high);
	}
}
void guibing(int a,int low,int mid,int high)
{
	int h1[mid-low+2]；
	int h2[high-mid+1];
	h1[mid-low+1]=100000;
	h2[high-mid]=100000;
	for(int i=low;i<=mid;i++)
	{
		h1[i-low]=a[i];
	}
	for(int i=mid+1;i<=high;i++)
	{
		h2[i-mid-1]=a[i];
	}
	int x1=0,x2=0;
	for(int i=low;i<=high;i++)
	{
		if(h1[x1]<h2[x2]){
			a[i]=h1[x1++];
		}else{
			a[i]=h1[x2++];
		}
	}
}




自写堆排序：
void headadjust(int a[],int size,int i){
	int lchild=2*i;
	int rchild=2*i+1;
	int max=i;
	if(i<=size/2){
		if(lchild<=size&&a[i]<a[lchild]){
			max=lchild;
		}
		if(rchild<=size&&a[i]<a[rchild]){
			max=rchild;
		}
	}
	if(max!=i){
		swap(a[i],a[max]);
		headadjust(a,size,max);
	}
}
void BuildHeap(int a[],int size){
	for(int i=size/2;i>=1;i--){
		headadjust(a,size,i);
	}
}
void HeapSort(int a,int size){
	int i;
	BuildHeap(a,size);
	for(int i=size;i>=1;i--){
		swap(a[1],a[i]);
		BuildHeap(a,size-1);
	}
}






DbLinkList* InsertEleDbLinkList(DbLinkList * pHead,int pos,int data){
	int count=1;
	if(pos<=0) return null;
	DbLinkList * p=pHead;
	while(count<pos){
		p=p->next;
		count++;
	}
	DbLinkList * pre=p->prior;
	DbLinkList * ans=(DbLinkList*)malloc(sizeof(DbLinkList));
	ans->data=data;
	ans->next=pre->next;
	pre->next->prior=ans;
	ans->prior=pre;
	pre->next=ans;
}


struct Tree{
	int data;
	Tree * lchild;
	Tree * rchild;
} 
int MaxPath(Tree t){
	if(t==null) return 0;
	return t->data+MaxPath(t->lchild)>MaxPath(t->rchild)?MaxPath(t->lchild):MaxPath(t->rchild);
}


void *memmove(void *dist,const void *src,int size_tcount){
	for(int i=0;i<size_tcount;i++)
	{
		&(src+i)=&(dist+i);
	}
	free(dist);
}


typedef struct BiTNode{  
    int data;  
    BiTNode *lchild, *rchild;  
}BiTNode,*BiTree;  
int max=0;
void PreOrderTraverse(BiTree T)//非递归先序遍历  
{  
      
    stack<BiTree> Stack;  
    if(!T) return 0;
    while(T || !Stack.empty())  
    {  
        while(T)  
        {  
            Stack.push(T);  
            max=max+T->data;
            T=T->lchild;  
        }
        T=Stack.top();  
        Stack.pop();          
             T=T->rchild;          
    }                                                                                                                                     
}  



int a[4001];
for(int i=0;i<4001;i++)
{
	a[i]=0;
}
//i对于的是数字，a[i]对应的出现次数

char b[10000];(假如这是字符串)
for(int j=0;j<b.lenght;j++){
	//遍历，得到每个空格数字x，然后a[x]=a[x]+1(对于数字出现的次数+1);
}
for(int i=0;i<4001;i++)
{
	//如果a[i](次数不为0)，打印i和a[i],如果为0，直接跳过去
}

its = '5 5 1 1 1'
it = its.split(' ')
m = list(set(it))
counters={}
for m in its:
	if m.trim=='':
		continue;
	else:  
    	if m in counters:
        	counters[m] +=1 
    	else:
        	counters[m] = 1 
for k,v in counters.items():
    if k.isdigit():
        print(k,v)