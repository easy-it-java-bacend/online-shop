package kg.easyit.onlineshop.service;

import kg.easyit.onlineshop.model.dto.RoleDto;
import kg.easyit.onlineshop.model.enums.Authority;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface RoleService {


    List<Authority> getAuthorities();
    RoleDto create(RoleDto roleDto);
    RoleDto findById(Long id);

}
