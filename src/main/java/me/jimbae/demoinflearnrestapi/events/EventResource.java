package me.jimbae.demoinflearnrestapi.events;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class EventResource extends Resource<Event> {

    public EventResource(Event event, Link... links) {
        super(event, links);
        //Self Link 의 경우 어처피 매번 추가해 주어야 하므로 생성자에서 미리 구현한다
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }
}
