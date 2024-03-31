package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code
		
		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
		
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

	/**
	 * Performs bitwise logical OR operation on two binary variables.
	 *
	 * @param num1 The first binary object containing the binary number
	 * @param num2 The second binary object containing the binary number
	 * @return A binary object with a value equal to the bitwise OR operation of num1 and num2.
	 */
	public static Binary bitwiseOR (Binary num1, Binary num2)
	{
		// the index of the first digit of each number
		int ind1 = num1.number.length()-1;
		int ind2 = num2.number.length()-1;

		String orValue = ""; // the binary value of the bitwise OR operation

		while (ind1 >= 0 && ind2 >= 0) // execute loop until all the digits of one of the numbers has been processed
		{
			if (num1.number.charAt(ind1)=='1' || num2.number.charAt(ind2)=='1') // if the current digit of num1 or num2 is a 1
			{
				orValue = "1" + orValue; // append a 1 to orValue
			}
			else // if the current digit of both num1 and num2 is a 0
			{
				orValue = "0" + orValue; // append a 0 to orValue
			}

			// update index values
			ind1--;
			ind2--;
		}

		if (ind1 >= 0) // if num1 still has remaining digits to be processed
		{
			for (int i = ind1; i >= 0; i--) // execute loop until the remaining digits of num1 has been processed
			{
				if (num1.number.charAt(i)=='1') // if the current digit of num1 is a 1
				{
					orValue = "1" + orValue; // append a 1 to orValue
				}
				else // if the current digit of num1 is a 0
				{
					orValue = "0" + orValue; // append a 0 to orValue
				}
			}
		}
		else if (ind2 >= 0) // if num2 still has remaining digits to be processed
		{
			for (int i = ind2; i >= 0; i--) // execute loop until the remaining digits of num2 has been processed
			{
				if (num2.number.charAt(i)=='1') // if the current digit of num2 is a 1
				{
					orValue = "1" + orValue; // append a 1 to orValue
				}
				else // if the current digit of num2 is a 0
				{
					orValue = "0" + orValue; // append a 0 to orValue
				}
			}
		}

		Binary orResult = new Binary(orValue);  // creates a binary object with bitwise OR value
		return orResult;
	}

	/**
	 * Performs bitwise logical AND operation on two binary variables.
	 *
	 * @param num1 The first binary object containing the binary number
	 * @param num2 The second binary object containing the binary number
	 * @return A binary object with a value equal to the bitwise AND operation of num1 and num2.
	 */
	public static Binary bitwiseAND (Binary num1, Binary num2)
	{
		// the index of the first digit of each number
		int ind1 = num1.number.length()-1;
		int ind2 = num2.number.length()-1;

		String andValue = ""; // the binary value of the bitwise AND operation
		int lengthDifference = ind1 - ind2; // the difference in length between the two numbers

		// get the absolute value of lengthDifference if it is negative
		if (lengthDifference < 0)
		{
			lengthDifference = lengthDifference * -1;
		}

		while (ind1 >= 0 && ind2 >= 0) // execute loop until all the digits of one of the numbers has been processed
		{
			if (num1.number.charAt(ind1)=='0' || num2.number.charAt(ind2)=='0') // if the current digit of num1 or num2 is a 0
			{
				andValue = "0" + andValue; // append a 0 to andValue
			}
			else // if the current digit of both num1 and num2 is a 1
			{
				andValue = "1" + andValue; // append a 1 to andValue
			}

			// update index values
			ind1--;
			ind2--;
		}

		Binary andResult = new Binary(andValue);  // creates a binary object with bitwise AND value
		return andResult;
	}

	/**
	 * Multiplying two binary variables.
	 *
	 * @param num1 The binary object containing the multiplicand
	 * @param num2 The binary object containing the multiplier
	 * @return A binary object with a value equal to <i>num1*num2</i>.
	 */
	public static Binary multiply (Binary num1, Binary num2)
	{
		Binary multiplyResult = new Binary("0"); // creates a binary object to hold the multiplication result
		String shiftedValue = ""; // the binary value of the multiplicand after it gets shifted
		int numOfShifts = 0; // indicates how many zeros have to be appended to the multiplicand

		for (int i = num2.number.length()-1; i >= 0; i--) // execute loop until each digit of the multiplier has been accessed
		{
			if (num2.number.charAt(i) == '1') // if the current digit of the multiplier is 1
			{
				shiftedValue = num1.number; // initialize with the multiplicand before any shifts

				for (int j = 0; j < numOfShifts; j++) // execute loop for the amount of zeros that must be added to the multiplicand
				{
					shiftedValue = shiftedValue + "0"; // add zeros to the multiplicand
				}

				Binary shiftedResult = new Binary(shiftedValue); // initialize new binary object with shifted value

				multiplyResult = add(multiplyResult, shiftedResult); // add shifted value to current product
			}

			numOfShifts++; // update the number of shifts needed for the next iteration
		}

		return multiplyResult;
	}
}	
