package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addStringAdd(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}
	
	@GetMapping("/add_json")
	public BinaryAPIResult addJSONAdd(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/multiply")
	public String addStringMultiply(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
							@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  Binary.multiply(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/multiply_json")
	public BinaryAPIResult addJSONMultiply(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
								   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  new BinaryAPIResult(number1,"multiply",number2,Binary.multiply(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/bitwiseOR")
	public String addStringOr(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
							@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  Binary.bitwiseOR(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/bitwiseOR_json")
	public BinaryAPIResult addJSONOr(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
								   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  new BinaryAPIResult(number1,"bitwiseOR",number2,Binary.bitwiseOR(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/bitwiseAND")
	public String addStringAnd(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
							@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  Binary.bitwiseAND(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/bitwiseAND_json")
	public BinaryAPIResult addJSONAnd(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
								   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  new BinaryAPIResult(number1,"bitwiseAND",number2,Binary.bitwiseAND(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

}
