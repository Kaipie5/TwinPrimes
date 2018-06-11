package twinprimes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TwinPrimes {

    public static void main(String[] args) throws IOException {

        int maxVal = 1000000;
        
    
        
        long timeStart = System.currentTimeMillis();

//        List<Integer> printArray = findTwinPrimes(maxVal);
//        System.out.println("!!!!!!!!!!!!!!!!!!RESULTS!!!!!!!!!!!!!!!!!!!!");
//        String fileName = maxVal + "primes.txt";
//
//        try {
//            FileWriter fileWriter =
//                new FileWriter(fileName);
//
//            BufferedWriter bufferedWriter =
//                new BufferedWriter(fileWriter);
//            for (int i = 0; i < printArray.size(); i+=2) {
//                bufferedWriter.write(printArray.get(i) + " : " + printArray.get(i + 1) + "\n");
//            }
//
//            bufferedWriter.close();
//        }
//        catch(IOException ex) {
//            System.out.println(
//                "Error writing to file '"
//                + fileName + "'");
//        }
///////////////////////////////////////////////////////////////////////////////
//        String line = null;
//
//        try {
//            FileReader fileReader = 
//                new FileReader(fileName);
//
//            BufferedReader bufferedReader = 
//                new BufferedReader(fileReader);
//
//            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }   
//
//            bufferedReader.close();         
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println(
//                "Unable to open file '" + 
//                fileName + "'");                
//        }
//        catch(IOException ex) {
//            System.out.println(
//                "Error reading file '" 
//                + fileName + "'");                  
//        }
        
        List<Integer> printArray = findTwinPrimes(maxVal);
        long timeEnd = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (timeEnd - timeStart));
        
//        for (int i = 0; i < printArray.size(); i+=2) {
//                System.out.println(printArray.get(i) + " : " + printArray.get(i + 1));
//        }
        
    }
    
    
    public static boolean isPrime(int primeCanidate) {
        
            boolean wasPrime = true;
            
            for (int divisor = 2; divisor <= Math.sqrt(primeCanidate); divisor++){
                
                if ((primeCanidate % divisor) == 0) {
                    wasPrime = false;
                    break;
                }
            }
        return wasPrime;
    }
    public static List<Integer> findTwinPrimes(int max){
        
        List<Integer> twinPrimes = new ArrayList();
        twinPrimes.add(1);
        twinPrimes.add(3);
        twinPrimes.add(3);
        twinPrimes.add(5);
        int prevPrime = 5;
        
        for (int primeCanidate = 5; primeCanidate < max; primeCanidate++) {
            if (primeCanidate%2 == 0) continue;
            
            if (isPrime(primeCanidate)) {
                if ((primeCanidate-2) == prevPrime) {
                    twinPrimes.add(prevPrime);
                    twinPrimes.add(primeCanidate);
                }
                prevPrime = primeCanidate;
            }
        }

        
        return twinPrimes;
    }
    
    
}
