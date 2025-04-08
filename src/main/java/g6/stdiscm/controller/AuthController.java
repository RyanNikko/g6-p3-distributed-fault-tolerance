package g6.stdiscm.controller;

import g6.stdiscm.model.User;
import g6.stdiscm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    
    // Simple login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {

        User user = userService.findByUsername(authRequest.getUsername());
        if (user == null || !user.getPassword().equals(authRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body("Invalid credentials");
        }

        // In a real application, you would generate and return a JWT token here
        return ResponseEntity.ok("Logged in successfully. Role: " + user.getRole());
    }
    
    // User registration endpoint
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest authRequest) {

        // In production, add validations and encode the password
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(authRequest.getPassword());
        user.setRole(authRequest.getRole());
        userService.saveUser(user);

        return ResponseEntity.ok("User registered successfully");
    }
}

class AuthRequest {
    private String username;
    private String password;
    private String role;  

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }
}