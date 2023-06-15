package com.scotia.todo.persistence.mapper;

import com.scotia.todo.domain.State;
import com.scotia.todo.persistence.entity.Status;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StateMapper {
    @Mappings({
            @Mapping(source = "idStatus", target = "stateID"),
            @Mapping(source = "name", target = "state"),
    })
    State toState(Status status);

    @InheritInverseConfiguration
    @Mapping(target = "tasks", ignore = true)
    Status toStatus(State state);

}
