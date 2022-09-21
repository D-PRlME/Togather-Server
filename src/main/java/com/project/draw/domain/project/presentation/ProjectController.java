package com.project.draw.domain.project.presentation;

import com.project.draw.domain.project.presentation.dto.request.AcceptInviteRequest;
import com.project.draw.domain.project.presentation.dto.request.CreateProjectRequest;
import com.project.draw.domain.project.presentation.dto.request.InviteUserRequest;
import com.project.draw.domain.project.presentation.dto.request.LeaveProjectRequest;
import com.project.draw.domain.project.presentation.dto.response.QueryMyInvitationResponse;
import com.project.draw.domain.project.service.AcceptInviteService;
import com.project.draw.domain.project.service.CreateProjectService;
import com.project.draw.domain.project.service.InviteUserService;
import com.project.draw.domain.project.service.LeaveProjectService;
import com.project.draw.domain.project.service.QueryMyInvitationService;
import com.project.draw.domain.project.service.QueryProjectInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/projects")
@RestController
public class ProjectController {

    private final CreateProjectService createProjectService;
    private final InviteUserService inviteUserService;
    private final QueryMyInvitationService queryMyInvitationService;
    private final AcceptInviteService acceptInviteService;
    private final LeaveProjectService leaveProjectService;
    private final QueryProjectInfoService queryProjectInfoService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    public void createProject(@RequestBody @Valid CreateProjectRequest request) {
        createProjectService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/invite")
    public void inviteUser(@RequestBody @Valid InviteUserRequest request) {
        inviteUserService.execute(request);
    }

    @GetMapping("/invite")
    public QueryMyInvitationResponse queryMyInvitation() {
        return queryMyInvitationService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/invite")
    public void acceptInvite(@RequestBody @Valid AcceptInviteRequest request) {
        acceptInviteService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/leave")
    public void leaveProject(@RequestBody @Valid LeaveProjectRequest request) {
        leaveProjectService.execute(request);
    }

}