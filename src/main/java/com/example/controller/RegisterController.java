//package com.example.controller;
//
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.example.entity.Register;
//import com.example.repository.RegisterRepository;
//
//@Controller
//@RequestMapping("/")
//public class RegisterController {
//
//	
//	private final RegisterRepository registerRepo;
//	@Autowired
//	public RegisterController(RegisterRepository registerRepo) {
//		
//		this.registerRepo = registerRepo;
//
//	}
//
////	@GetMapping("/")
////	public String home() {
////		return "home";
////	}
////	
////	 @RequestMapping("/index")
////	    public String index() {
////	        return "index";
////	    }
////	
////	@GetMapping("/book_register")
////	public String bookRegister() {
////		return "bookRegister";
////	}
//
//	 @GetMapping
//	    public String showRegistrationForm(Model model) {
//	        model.addAttribute("register", new Register());
//	        return "index";
//	    }
//
//	    @PostMapping("/save")
//	    public String processRegistrationForm(Register registration) {
//	        // Perform necessary actions with the registration data (e.g., saving to a database)
//	        // You can add your custom logic here
//
//	        return "redirect:/success"; // Redirect to a success page
//	    }
//
//	    @GetMapping("/success")
//	    public String showSuccessPage() {
//	        return "success";
//	    }
//	@PostMapping("/regi")
//	public ResponseEntity<Register> saveRegister(@RequestBody Register register) {
//		return new ResponseEntity<>(registerRepo.save(register), HttpStatus.OK);
//	}
//
//	@GetMapping("/regi")
//	public ResponseEntity<List<Register>> getRegister() {
//		return new ResponseEntity<>(registerRepo.findAll(), HttpStatus.OK);
//	}

//@GetMapping("/api/Item/{Id}")
//
//public ResponseEntity<Item> getItem(@PathVariable long id) {
//
//java.util.Optional<Item> item = itemRepo.findById(id);
//
//if (item.isPresent()) {
//
//return new ResponseEntity<>(item.get(), HttpStatus.OK);
//
//} else {
//
//return new ResponseEntity<>(HttpStatus.NOT_FOUND);


//
//	@PutMapping("/regi/{id}")
//	public ResponseEntity<Register> updateRegister(@PathVariable long id, @RequestBody Register item) {
//		Optional<Register> register = registerRepo.findById(id);
//		if (register.isPresent()) {
//			register.get().setName(item.getName());
//			register.get().setEmail(item.getEmail());
//			register.get().setPassword(item.getPassword());
//			return new ResponseEntity<>(registerRepo.save(register.get()), HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@DeleteMapping("/regi/{id}")
//	public ResponseEntity<Void> deleteRegister(@PathVariable long id) {
//		Optional<Register> register = registerRepo.findById(id);
//		if (register.isPresent()) {
//			registerRepo.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//}


package com.example.controller;

import com.example.entity.Register;
import com.example.repository.RegisterRepository;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//@RestController
@Controller
@RequestMapping("/")
public class RegisterController {

    private final RegisterRepository registerRepo;

    @Autowired
    public RegisterController(RegisterRepository registerRepo) {
        this.registerRepo = registerRepo;
    }

//    @GetMapping
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("register", new Register());
//        return "index";
//    }

//    @GetMapping
//    public String showRegistrationForm(Model model) {
//        Register register = new Register();
//        // Set specific attributes
//        model.addAttribute("name", register.getName());
//        model.addAttribute("email", register.getEmail());
//        return "index";
//    }
    
    @GetMapping("/index")
    public String showRegistrationForm(Register register) {
        return "index";
    }


    @PostMapping("/save")
    public String processRegistrationForm(@ModelAttribute("register") Register registration) {
        registerRepo.save(registration);
        return "redirect:/try";
    }

    @GetMapping("/try")
    public String showSuccessPage() {
        return "try";
    }
//    @PostMapping("/save/form")
//	
//	public Register save(@RequestBody Register register) {
//		return  registerRepo.save( register) ;
//}
    
  // this if for download 
    


    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<FileSystemResource> downloadFile() {
        String filePath = "/path/to/file.png";
        File file = new File(filePath);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=file.png");

        try {
            String mimeType = MediaType.IMAGE_PNG_VALUE;
            MediaType mediaType = MediaType.parseMediaType(mimeType);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(mediaType)
                    .body(new FileSystemResource(file));
        } catch (Exception e) {
            // Handle the exception if any
            return ResponseEntity.notFound().build();
        }
    }
    }
    

