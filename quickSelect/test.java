import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class test{
    public static void main(String[] args) {
		int InputDataSize = 20000;
        int RuningTimes = 10000;
        String filenamex = "output_10_20000_r.txt";
        
        int[] a=new int[InputDataSize];
		FileReader fr;
		BufferedReader br;
		try
		{	fr=new FileReader(filenamex);
			br = new BufferedReader(fr);
			int i=0;
			while (br.ready())
			{
				a[i++]=Integer.parseInt(br.readLine());
			}
		}catch(FileNotFoundException e)
		{}catch(IOException e2)
		{}
		

        long time_start=System.nanoTime();
        
		for(int i=0;i<RuningTimes;i++)
		{
			int[] ex=new int[a.length];
			System.arraycopy(a, 0, ex, 0, a.length);
            quickSelect test = new quickSelect();

            System.out.println(i+1 + " " + test.Median(ex));
        }

        System.out.println("time:"+(System.nanoTime()-time_start)/RuningTimes);
    }

}
