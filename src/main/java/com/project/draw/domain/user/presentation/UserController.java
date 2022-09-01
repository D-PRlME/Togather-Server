package com.project.draw.domain.user.presentation;

import com.project.draw.domain.auth.presentation.dto.TokenResponse;
import com.project.draw.domain.user.presentation.dto.request.CheckEmailRequest;
import com.project.draw.domain.user.presentation.dto.request.FindPasswordRequest;
import com.project.draw.domain.user.presentation.dto.request.LoginRequest;
import com.project.draw.domain.user.presentation.dto.request.SendAuthCodeRequest;
import com.project.draw.domain.user.presentation.dto.request.SignupRequest;
import com.project.draw.domain.user.presentation.dto.request.UpdateEmailRequest;
import com.project.draw.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.project.draw.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.project.draw.domain.user.presentation.dto.request.VerifyAuthCodeRequest;
import com.project.draw.domain.user.presentation.dto.response.QueryUserInfoResponse;
import com.project.draw.domain.user.service.CheckEmailService;
import com.project.draw.domain.user.service.FindPasswordService;
import com.project.draw.domain.user.service.LoginService;
import com.project.draw.domain.user.service.LogoutService;
import com.project.draw.domain.user.service.QueryMyInfoService;
import com.project.draw.domain.user.service.QueryUserInfoService;
import com.project.draw.domain.user.service.SendAuthCodeService;
import com.project.draw.domain.user.service.SendSignupAuthCodeService;
import com.project.draw.domain.user.service.SignupService;
import com.project.draw.domain.user.service.TokenRefreshService;
import com.project.draw.domain.user.service.UpdateEmailService;
import com.project.draw.domain.user.service.UpdatePasswordService;
import com.project.draw.domain.user.service.UpdateUserInfoService;
import com.project.draw.domain.user.service.VerifyAuthCodeService;
import com.project.draw.domain.user.service.WithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final CheckEmailService checkEmailService;
    private final SendSignupAuthCodeService sendSignupAuthCodeService;
    private final VerifyAuthCodeService verifyAuthCodeService;

    private final SignupService signupService;
    private final LoginService loginService;
    private final TokenRefreshService tokenRefreshService;

    private final QueryMyInfoService queryMyInfoService;
    private final QueryUserInfoService queryUserInfoService;

    private final UpdateUserInfoService updateUserInfoService;
    private final UpdatePasswordService updatePasswordService;
    private final UpdateEmailService updateEmailService;

    private final SendAuthCodeService sendAuthCodeService;
    private final FindPasswordService findPasswordService;

    private final LogoutService logoutService;
    private final WithdrawalService withdrawalService;

    @PostMapping("/mail/duplicate")
    public void checkEmail(@RequestBody @Valid CheckEmailRequest request){
        checkEmailService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/mail/signup")
    public void sendSignupAuthCodeService(@RequestBody @Valid SendAuthCodeRequest request){
        sendSignupAuthCodeService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/mail/verify")
    public void verifyAuthCode(@RequestBody @Valid VerifyAuthCodeRequest request) {
        verifyAuthCodeService.execute(request);
    }

    @PostMapping
    public TokenResponse signup(@RequestBody @Valid SignupRequest request){
        return signupService.execute(request);
    }

    @PostMapping("/auth")
    public TokenResponse login(@RequestBody @Valid LoginRequest request){
        return loginService.execute(request);
    }

    @PutMapping("/auth")
    public TokenResponse tokenRefresh(@RequestHeader("X-Refresh-Token") String refreshToken){
        return tokenRefreshService.execute(refreshToken);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping
    public void updateUserInfo(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void updateUserPassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/email")
    public void updateEmail(@RequestBody @Valid UpdateEmailRequest request) {
        updateEmailService.execute(request);
    }

    @GetMapping
    public QueryUserInfoResponse queryMyInfo() {
        return queryMyInfoService.execute();
    }

    @GetMapping("/{user-id}")
    public QueryUserInfoResponse queryUserInfo(@PathVariable("user-id") Long userId) {
        return queryUserInfoService.execute(userId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/mail")
    public void sendAuthCodeService(@RequestBody @Valid SendAuthCodeRequest request){
        sendAuthCodeService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/password")
    public void findPassword(@RequestBody @Valid FindPasswordRequest request) {
        findPasswordService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout(){
        logoutService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void withdrawal(){
        withdrawalService.execute();
    }
}