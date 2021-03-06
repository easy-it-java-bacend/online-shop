package kg.easyit.onlineshop.service.impl;

import kg.easyit.onlineshop.exceptions.UserNotFoundException;
import kg.easyit.onlineshop.mapper.RoleMapper;
import kg.easyit.onlineshop.model.dto.RoleDto;
import kg.easyit.onlineshop.model.entity.Role;
import kg.easyit.onlineshop.model.enums.Authority;
import kg.easyit.onlineshop.repository.RoleRepository;
import kg.easyit.onlineshop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public Boolean existByRoleName(String name) {
        return roleRepository.existsByRoleName(name);
    }

    @Override
    public List<Authority> getAuthorities() {
        return Stream.of(Authority.values()).collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(Long id) {
        return RoleMapper.INSTANCE.toDto(roleRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("Role id not found")));
    }

    @Override
    public RoleDto create(RoleDto roleDto) {
        if(roleRepository.existsByRoleName(roleDto.getRoleName())){
            throw new RuntimeException("Role name" + roleDto.getRoleName() + "already is exists" );
        }
        return RoleMapper.INSTANCE
                .toDto(roleRepository
                        .save(RoleMapper.INSTANCE.toEntity(roleDto)));
    }
}
