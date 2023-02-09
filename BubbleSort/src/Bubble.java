import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Bubble{

public static void swap(int[] array, int i, int j)
{
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

public static void swap(int[] array, int n)
{
    for(int i = 0; i < n-1; i++)
    {
        if(array[i] > array[i+1])
        {
            swap(array, i, i+1);
        }
    }
}

public static void bubbleSort(int[] array, int n)
{
    if(n > 1){
        swap(array, n);
        bubbleSort(array, n-1);
    }
}

public static void bubbleSort(int[] array)
{
    bubbleSort(array, array.length);

}

public static boolean isSorted(int[] array)
{
    for(int i = 0; i < array.length - 1; i++){
        if(array[i] > array[i + 1])
        return false;
    }
    return true;
}
public static int[] createRandomArray(int arrayLength)
{
    int[] array = new int[arrayLength];
    Random random = new Random();
    for(int i = 0; i < arrayLength; i++)
    {
        array[i] = random.nextInt(100);
    }
    return array;
}

public static void writeArrayToFile(int[] array, String filename)
{
    try(FileWriter fileWriter = new FileWriter(filename))
    {
        for(int i = 0; i < array.length; i++)
        {
            fileWriter.write(array[i] + "\n");
        }
    }
    catch(IOException e)
    {

    }
}

public static int[] readFiletoArray(String filename)
{
ArrayList<Integer> arrayList = new ArrayList<>();
try
{
File file = new File(filename);
Scanner scanner = new Scanner(file);
while(scanner.hasNextLine())
{
    String s = scanner.nextLine();
    arrayList.add(Integer.parseInt(s));
}
scanner.close();
}
catch(IOException e) 
{

}

int[] array = new int[arrayList.size()];
for(int i = 0; i < array.length; i++)
{
    array[i] = arrayList.get(i);
}
return array;
}

public static void main(String[] args) throws Exception 
{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please input the array length");
    int arrayLength = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Please input the initial file name");
    String IntialFileName = scanner.nextLine();
    System.out.println("Please input the bubble sorted file name");
    String BubbleSortedFileName = scanner.nextLine();
    int[] array = createRandomArray(arrayLength);
    writeArrayToFile(array, IntialFileName + ".txt");
    array = readFiletoArray(IntialFileName + ".txt");
    System.out.println(Arrays.toString(array));
    bubbleSort(array);
    System.out.println("Bubble Sort Result:\n" + Arrays.toString(array));
    writeArrayToFile(array, BubbleSortedFileName + ".txt");
}
}