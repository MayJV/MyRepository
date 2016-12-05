package testhadoop.testhadoop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class SortBean implements WritableComparable<SortBean>{
	private String left;
	private int right;
	
	public void set(String left, int right) {
		this.left = left;
		this.right = right;
	}
	public SortBean(){
		
	}
	@Override
	public String toString() {
		return  this.left + "," + this.right ;
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	
	
	public void readFields(DataInput arg0) throws IOException {
		// TODO 自动生成的方法存根
		this.left = arg0.readUTF();
		this.right=arg0.readInt();
		
	}
	public void write(DataOutput arg0) throws IOException {
		// TODO 自动生成的方法存根
		arg0.writeUTF(left);
		arg0.writeInt(right);
	}
	public int compareTo(SortBean o) {
		// TODO 自动生成的方法存根
		//相同输出为零
		int num=this.getLeft().compareTo(o.getLeft());
		int num2=(num==0)?this.getRight()-o.getRight():num;
		return num2;
	}
	

}
