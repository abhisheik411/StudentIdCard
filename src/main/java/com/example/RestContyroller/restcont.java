package com.example.RestContyroller;
//
//
//
//import java.util.List;
//
//import org.apache.catalina.connector.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.entity.Register;
//import com.example.repository.RegisterRepository;
//@RestController
//public class restcont {
//	 private final RegisterRepository registerRepo;
//
//	public restcont(RegisterRepository registerRepo) {
//		super();
//		this.registerRepo = registerRepo;
//	}
//	@PostMapping("/save/form")
//	
//		public Register save(@RequestBody Register register) {
//			return  registerRepo.save( register) ;
//	}
//	@PutMapping("/P/{id}")
//	public ResponseEntity<Register> updateitem (@PathVariable Long id @ResponseBody Register register){
//		Optional<Register>  regOpt= registerRepo.findById(id);
//		if(regOpt.isPresent()) {
//			
//		}
//	
//	@GetMapping("/get/{id}")
//	public ResponseEntity<Register> getName(@PathVariable int id){
//		java.util.Optional<Register> RegOpt=registerRepo.findById((long) id);
//		Register register =RegOpt.get();
//		return new ResponseEntity<Register>(register,HttpStatus.OK);
//	}
//	@GetMapping("/all")
//	public ResponseEntity<List<Register>> getAll(){
//		List<Register> listall=registerRepo.findAll();
//		return new ResponseEntity<>(listall,HttpStatus.OK);
//		
//	}
//	
//	@DeleteMapping ("/D/{id}")
//	public ResponseEntity<Register> delete(@PathVariable int id)
//	{
//		registerRepo.deleteById((long) id);
//		return new ResponseEntity<Register>(HttpStatus.OK);	
//	}
//
//	package com.example.RestContyroller;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Register;
import com.example.repository.RegisterRepository;

@RestController
public class restcont {
	private final RegisterRepository registerRepo;

	@Autowired
	public restcont(RegisterRepository registerRepo) {
		super();
		this.registerRepo = registerRepo;
	}

	@PostMapping("/save/form")
	public Register save(@RequestBody Register register) {
		return registerRepo.save(register);
	}

	@PutMapping("/P/{id}")
	public ResponseEntity<Register> updateitem(@PathVariable Long id, @RequestBody Register register) {
		Optional<Register> regOpt = registerRepo.findById(id);
		if (regOpt.isPresent()) {
			Register updatedRegister = regOpt.get();
			updatedRegister.setName(register.getName());
			updatedRegister.setEmail(register.getEmail());
			updatedRegister.setPhone(register.getPhone());
			updatedRegister.setCollage(register.getCollage());
			updatedRegister.setStudent_id(register.getStudent_id());
			// Update other fields as needed
			registerRepo.save(updatedRegister);
			return new ResponseEntity<>(updatedRegister, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Register> getName(@PathVariable int id) {
		Optional<Register> regOpt = registerRepo.findById((long) id);
		if (regOpt.isPresent()) {
			Register register = regOpt.get();
			return new ResponseEntity<>(register, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<Register>> getAll() {
		List<Register> listall = registerRepo.findAll();
		return new ResponseEntity<>(listall, HttpStatus.OK);
	}

	@DeleteMapping("/D/{id}")
	public ResponseEntity<Register> delete(@PathVariable int id) {
		registerRepo.deleteById((long) id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	


}


