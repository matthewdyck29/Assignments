package fizzbuzzTests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.OptionalInt;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fizzbuzz.EnhancedFizzBuzz;

public class EnhancedFizzBuzzTester {
	private static final PrintStream stdOut = System.out;
	private static ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	
	@BeforeClass
	public static void beforeClass() {
		System.setOut(new PrintStream(outStream));
	}
	
	@Test
	public void testNumber() {
		EnhancedFizzBuzz.checkNumbers(0, 0);
		Assert.assertTrue(outStream.toString().indexOf("0") != -1);
		Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 0\nfizzbuzz: 0\n" 
				+ "lucky: 0\ninteger: 1") != -1);
		EnhancedFizzBuzz.checkNumbers(-1, -1);
		Assert.assertTrue(outStream.toString().indexOf("-1") != -1);
		Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 0\nfizzbuzz: 0\n" 
				+ "lucky: 0\ninteger: 1") != -1);
		
		EnhancedFizzBuzz.checkNumbers(1, 1);
		Assert.assertTrue(outStream.toString().indexOf("1") != -1);
		Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 0\nfizzbuzz: 0\n" 
				+ "lucky: 0\ninteger: 1") != -1);
	}
	
	@Test
	public void testFizz() {
		EnhancedFizzBuzz.checkNumbers(6, 6);
		Assert.assertTrue(outStream.toString().indexOf("fizz") != -1);
		Assert.assertTrue(outStream.toString().indexOf("fizz: 1\nbuzz: 0\nfizzbuzz: 0\n" 
				+ "lucky: 0\ninteger: 0") != -1);
	}
	
	@Test
	public void testBuzz() {
		EnhancedFizzBuzz.checkNumbers(5, 5);
		Assert.assertTrue(outStream.toString().indexOf("buzz") != -1);
		Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 1\nfizzbuzz: 0\n" 
				+ "lucky: 0\ninteger: 0") != -1);
	}
	
	@Test
	public void testFizzBuzz() {
		EnhancedFizzBuzz.checkNumbers(15, 15);
		Assert.assertTrue(outStream.toString().indexOf("fizzbuzz") != -1);
		Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 0\nfizzbuzz: 1\n" 
				+ "lucky: 0\ninteger: 0") != -1);
	}
	
	@Test
	public void testLucky() {
		Random random = new Random();
		OptionalInt number = random.ints().filter((integer) -> (new Integer(integer).toString().contains("3"))
				).findFirst();
		EnhancedFizzBuzz.checkNumbers(number.getAsInt(), number.getAsInt());
		Assert.assertTrue(outStream.toString().indexOf("lucky") != -1);
		Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 0\nfizzbuzz: 0\n" 
				+ "lucky: 1\ninteger: 0") != -1);
	}
	
	@Test
	public void testRandom() {
		Random random = new Random();
		int number = random.nextInt();
		
		EnhancedFizzBuzz.checkNumbers(number, number);
		if(number == 0) {
			Assert.assertTrue(outStream.toString().indexOf("0") != -1);
			Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 0\nfizzbuzz: 0\n" 
					+ "lucky: 0\ninteger: 1") != -1);
		} else if(new Integer(number).toString().contains("3")) {
			Assert.assertTrue(outStream.toString().indexOf("lucky") != -1);
			Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 0\nfizzbuzz: 0\n" 
					+ "lucky: 1\ninteger: 0") != -1);
		} else if(number % 15 == 0) {
			Assert.assertTrue(outStream.toString().indexOf("fizzbuzz") != -1);
			Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 0\nfizzbuzz: 1\n" 
					+ "lucky: 0\ninteger: 0") != -1);
		} else if(number % 5 == 0) {
			Assert.assertTrue(outStream.toString().indexOf("buzz") != -1);
			Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 1\nfizzbuzz: 0\n" 
					+ "lucky: 0\ninteger: 0") != -1);
		} else if(number % 3 == 0) {
			Assert.assertTrue(outStream.toString().indexOf("fizz") != -1);
			Assert.assertTrue(outStream.toString().indexOf("fizz: 1\nbuzz: 0\nfizzbuzz: 0\n" 
					+ "lucky: 0\ninteger: 0") != -1);
		} else {
			Assert.assertTrue(outStream.toString().indexOf(number) != -1);
			Assert.assertTrue(outStream.toString().indexOf("fizz: 0\nbuzz: 0\nfizzbuzz: 0\n" 
					+ "lucky: 0\ninteger: 1") != -1);
		}
	}
	
	@AfterClass
	public static void afterClass() {
		System.setOut(stdOut);
	}
	
}
