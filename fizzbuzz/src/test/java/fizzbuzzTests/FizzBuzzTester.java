package fizzbuzzTests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fizzbuzz.FizzBuzz;

public class FizzBuzzTester {
	private static final PrintStream stdOut = System.out;
	private static ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	
	@BeforeClass
	public static void beforeClass() {
		System.setOut(new PrintStream(outStream));
	}
	
	@Test
	public void testNumber() {
		FizzBuzz.checkNumbers(0, 0);
		Assert.assertTrue(outStream.toString().indexOf("0") != -1);
		
		FizzBuzz.checkNumbers(-1, -1);
		Assert.assertTrue(outStream.toString().indexOf("-1") != -1);
		
		FizzBuzz.checkNumbers(1, 1);
		Assert.assertTrue(outStream.toString().indexOf("1") != -1);
	}
	
	@Test
	public void testFizz() {
		FizzBuzz.checkNumbers(3, 3);
		Assert.assertTrue(outStream.toString().indexOf("fizz") != -1);
	}
	
	@Test
	public void testBuzz() {
		FizzBuzz.checkNumbers(5, 5);
		Assert.assertTrue(outStream.toString().indexOf("buzz") != -1);
	}
	
	@Test
	public void testFizzBuzz() {
		FizzBuzz.checkNumbers(15, 15);
		Assert.assertTrue(outStream.toString().indexOf("fizzbuzz") != -1);
	}
	
	@Test
	public void testRandom() {
		Random random = new Random();
		int number = random.nextInt();
		
		FizzBuzz.checkNumbers(number, number);
		if(number == 0) {
			Assert.assertTrue(outStream.toString().indexOf("0") != -1);
		} else if(number % 15 == 0) {
			Assert.assertTrue(outStream.toString().indexOf("fizzbuzz") != -1);
		} else if(number % 5 == 0) {
			Assert.assertTrue(outStream.toString().indexOf("buzz") != -1);
		} else if(number % 3 == 0) {
			Assert.assertTrue(outStream.toString().indexOf("fizz") != -1);
		} else {
			Assert.assertTrue(outStream.toString().indexOf(number) != -1);
		}
	}
	
	@AfterClass
	public static void afterClass() {
		System.setOut(stdOut);
	}
	
}
