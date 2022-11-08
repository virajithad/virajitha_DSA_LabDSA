import java.util.ArrayList;
import java.util.Scanner;

public class BSTSum {
	ArrayList<Integer> listNode = new ArrayList<>();
	public static Node newNode(int data) 
	{
		Node temp = new Node();
		temp.left = null;
		temp.data = data;
		temp.right = null;
		
		return temp;
	}

	public void insert(Node root, Node nn)
	{
		if(nn.data < root.data)
		{
			if(root.left==null)
			{
				root.left = nn;
			}
			else
			{
				insert(root.left, nn);
			}
		}
		else
		{
			if(root.right==null)
			{
				root.right = nn;
			}
			else
			{
				insert(root.right, nn);
			}
		}
	}
	
	private void traverse(Node root)
	{
		if(root!=null)//LDR
		{
			traverse(root.left);
			listNode.add(root.data);
			traverse(root.right);
		}
	}
	public static void main(String[] args) 
	{
		BSTSum bst = new BSTSum();
		Node root = null;
		Node nn = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes");
		
		int k = sc.nextInt();
		
		for(int i=0;i<k;i++)
		{
			System.out.println("enter the data for node");
			int n = sc.nextInt();
			nn = newNode(n);
			if(root==null)
			{
				root = nn;
			}
			else
			{
				bst.insert(root,nn);
				
			}
		}
		bst.traverse(root);
		System.out.println("Enter Sum");
		int sum = sc.nextInt();
		int flag= 0;
		
		for(int i=0; i<bst.listNode.size(); i++)
		{
			if(bst.listNode.contains(sum-bst.listNode.get(i)) && 
					bst.listNode.get(i)!= sum-bst.listNode.get(i))
			{
				System.out.println("pair found");
				System.out.println("["+ bst.listNode.get(i)+ "," + (sum-bst.listNode.get(i))+ "]");
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("Pair not found");
		}
		sc.close();
	}
	
}
