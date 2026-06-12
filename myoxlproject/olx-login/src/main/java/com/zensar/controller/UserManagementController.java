package com.zensar.controller;

/*
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.BadCredentialsException; import
 * org.springframework.security.authentication.DisabledException; import
 * org.springframework.security.authentication.LockedException; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.web.bind.annotation.*;
 * 
 * import com.zensar.dto.AuthResponseDto; import com.zensar.dto.LoginRequest;
 * import com.zensar.dto.UserDto; import com.zensar.entity.UserEntity; import
 * com.zensar.repo.TokenServiceImpl; import com.zensar.repo.UserService; import
 * com.zensar.security.JwtUtils; import com.zensar.service.DBUserService;
 * 
 * @RestController
 * 
 * @RequestMapping("/user-management") public class UserManagmentController {
 * 
 * @Autowired AuthenticationManager authenticationManager;
 * 
 * @Autowired UserDetailsService userDetailsService;
 * 
 * @Autowired JwtUtils jwtUtils;
 * 
 * @Autowired DBUserService dBUserService;
 * 
 * @Autowired UserService userService;
 * 
 * @Autowired TokenServiceImpl tokenServiceImpl;
 * 
 * @PostMapping(value = "/user/authenticate", consumes =
 * MediaType.APPLICATION_JSON_VALUE, produces =
 * MediaType.APPLICATION_JSON_VALUE) // Public public
 * ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequest loginRequest)
 * {
 * 
 * try { Authentication authentication = authenticationManager.authenticate( new
 * UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
 * loginRequest.getPassword()));
 * 
 * UserDetails userDetails = (UserDetails) authentication.getPrincipal(); String
 * token = jwtUtils.generateToken(userDetails); String expiration =
 * jwtUtils.extractExpiration(token).toString(); return ResponseEntity.ok(new
 * AuthResponseDto(token, expiration));
 * 
 * } catch (BadCredentialsException e) { return
 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); } catch
 * (DisabledException | LockedException e) { return
 * ResponseEntity.status(HttpStatus.FORBIDDEN).build(); } }
 * 
 * @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE,
 * produces = MediaType.APPLICATION_JSON_VALUE) // Public public
 * ResponseEntity<UserDto> userRegister(@RequestBody UserDto userDto) {
 * 
 * dBUserService.userRegistor(userDto);
 * 
 * return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED); }
 * 
 * @GetMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE,
 * produces = MediaType.APPLICATION_JSON_VALUE) // Public public
 * ResponseEntity<UserDto> getUserInfo(@RequestHeader("Authorization") String
 * authToken) { String token = authToken.substring(7); String userName =
 * jwtUtils.extractUsername(token); UserDto userDto =
 * dBUserService.getUserInfo(userName); if (userDto == null) return new
 * ResponseEntity<UserDto>(new UserDto(), HttpStatus.NOT_FOUND); else return new
 * ResponseEntity<UserDto>(dBUserService.getUserInfo(userName), HttpStatus.OK);
 * }
 * 
 * @DeleteMapping(value = "/user/logout") public ResponseEntity<Boolean>
 * logOut(@RequestHeader("Authorization") String authToken) {
 * 
 * String token = authToken.substring(7); String username =
 * jwtUtils.extractUsername(token); boolean isTokenValid =
 * jwtUtils.validateToken(token,
 * userDetailsService.loadUserByUsername(username)); boolean isTokenPresent =
 * tokenServiceImpl.getTokens(authToken).size() > 0; if (isTokenValid &&
 * !isTokenPresent) { tokenServiceImpl.addToken(authToken); return new
 * ResponseEntity<Boolean>(true, HttpStatus.OK); } else return new
 * ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
 * 
 * }
 * 
 * @GetMapping(value = "/user/token/validate") public ResponseEntity<Boolean>
 * validateToken(@RequestHeader("Authorization") String authToken) { authToken =
 * authToken.substring(7); String username =
 * jwtUtils.extractUsername(authToken); boolean isTokenValid =
 * jwtUtils.validateToken(authToken,
 * userDetailsService.loadUserByUsername(username)); boolean isTokenPresent =
 * tokenServiceImpl.getTokens(authToken).size() > 0; if (isTokenValid &&
 * !isTokenPresent) {
 * 
 * return new ResponseEntity<Boolean>(true, HttpStatus.OK); } else return new
 * ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST); } }
 */

import com.zensar.dto.AuthResponseDto;
import com.zensar.dto.LoginRequest;
import com.zensar.dto.UserDto;
import com.zensar.repo.TokenServiceImpl;
import com.zensar.security.JwtUtils;
import com.zensar.service.DBUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-management")
public class UserManagementController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final DBUserService dbUserService;
    private final TokenServiceImpl tokenService;

    // 1. Industry Standard: Used constructor injection instead of @Autowired
    public UserManagementController(AuthenticationManager authenticationManager,
                                    UserDetailsService userDetailsService,
                                    JwtUtils jwtUtils,
                                    DBUserService dbUserService,
                                    TokenServiceImpl tokenService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
        this.dbUserService = dbUserService;
        this.tokenService = tokenService;
    }

    @PostMapping(value = "/user/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
            );

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String token = jwtUtils.generateToken(userDetails);
            String expiration = jwtUtils.extractExpiration(token).toString();

            return ResponseEntity.ok(new AuthResponseDto(token, expiration));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (DisabledException | LockedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> userRegister(@Valid @RequestBody UserDto userDto) {
        // 2. Fix: Captured and returned the actual saved DTO with generated ID
        UserDto savedUserDto = dbUserService.userRegistor(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDto);
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserInfo(@RequestHeader("Authorization") String authToken) {
        String token = extractBearerToken(authToken);
        String userName = jwtUtils.extractUsername(token);
        UserDto userDto = dbUserService.getUserInfo(userName);

        if (userDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping(value = "/user/logout")
    public ResponseEntity<Boolean> logOut(@RequestHeader("Authorization") String authToken) {
        String token = extractBearerToken(authToken);
        
        if (isTokenValidAndNotBlacklisted(token)) {
            tokenService.addToken(token); 
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }

    @GetMapping(value = "/user/token/validate")
    public ResponseEntity<Boolean> validateToken(@RequestHeader("Authorization") String authToken) {
        String token = extractBearerToken(authToken);

        if (isTokenValidAndNotBlacklisted(token)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }

    private String extractBearerToken(String authToken) {
        if (authToken != null && authToken.startsWith("Bearer ")) {
            return authToken.substring(7);
        }
        return authToken;
    }

      private boolean isTokenValidAndNotBlacklisted(String token) {
        String username = jwtUtils.extractUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        
        boolean isTokenValid = jwtUtils.validateToken(token, userDetails);
        boolean isTokenPresent = !tokenService.getTokens(token).isEmpty(); 
        
        return isTokenValid && !isTokenPresent;
    }
}

