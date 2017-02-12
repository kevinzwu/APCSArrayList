import java.util.Arrays;
//Kevin Wu version 1.4
public class APArrayIntList implements APIntList{
	public int[] arr;
	public int Lens;
	public void resize(){
		Lens *= 2;//times the size by 2
	}
	public APArrayIntList(){
		arr = new int[Lens];
	}
	public int get(int given){
		return arr[given];
	}
	public void add(int list){
		int[] temp = new int[arr.length+1];
		for(int k = 0; k<arr.length; k++){
			temp[k] = arr[k];
			if(k == arr.length){
				resize();//calls the method resize if requirements meet
			}
		}
		temp[Lens] = list;
		arr = temp;
		Lens++;
	}
	private void resize(int[] array){
		Arrays.copyOf(arr,(arr.length+1)*2);
	}
	@Override
	public void add(int given, int list){
		int[] temp = new int[arr.length+1];
		for(int k = 0; k<arr.length; k++){
			temp[k] = arr[k];
		}
		for(int k = given; k<arr.length; k++){
			temp[k+1] = arr[k];
			if(k == arr.length){
				resize();
			}
		}
		temp[given] = list;
		arr = temp;
		Lens++;
	}
	@Override
	public int size(){
		return arr.length;
	}
	@Override
	public void set(int given, int list){
		arr[given]=list;
	}
}
