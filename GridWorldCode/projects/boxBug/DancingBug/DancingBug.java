package info.gridworld.actor;
import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
	//表示转向的数组
	private int[] arr;
	//表示当前数组的元素位置
	private int count;
	//表示移动的长度
	private int length;
	public DancingBug(int[] arr)
    {
		count = 0;
		length = arr.length;
		this.arr = new int[length];
		//初始化转向数组
		for (int i = 0; i < length; i++)
		{
			this.arr[i] = arr[i];
		}
	}

	public void act()
	{	
		//根据转向数组元素来转向
		for (int i = 0; i < arr[count]; i++)
		{
				turn();
		}
		//当前数组元素下标右移
		count = (++count) % length;
		//移动
		if (canMove())
		{
			move();
		}
		//否则转向
		else
		{
			turn();
		}
	}
}
