package com.dkt.school.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.common.util.ListUtil;
import com.dkt.school.user.dto.AuthorityDto;
import com.dkt.school.user.dto.RoleDto;
import com.dkt.school.user.model.Authority;
import com.dkt.school.user.model.Role;
import com.dkt.school.user.service.AuthorityService;
import com.dkt.school.user.service.RoleAuthorityService;
import com.dkt.school.user.service.RoleService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created with com.dkt.school.user.controller by Harry on 2015/5/9 11:59.
 */

@Controller
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    private AuthorityService authorityService;
    private RoleAuthorityService roleAuthorityService;

    public RoleService getRoleService() {
        return roleService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }


    public AuthorityService getAuthorityService() {
        return authorityService;
    }

    @Autowired
    public void setAuthorityService(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    public RoleAuthorityService getRoleAuthorityService() {
        return roleAuthorityService;
    }
    @Autowired
    public void setRoleAuthorityService(RoleAuthorityService roleAuthorityService) {
        this.roleAuthorityService = roleAuthorityService;
    }

    @RequestMapping("/roleList")
    public String roleList(){
        return "user/roleList";
    }

    /**
     * 根据角色名模糊分页查询
     * @param name
     * @param page
     * @return String
     */

    @ResponseBody
    @RequestMapping("/getRoleList")
    public String getRoleList(String name,PaginationCustom page){

        int total=roleService.getRoleCount(name);

        //设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());

        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);

        List<Role> roleList=roleService.getRolesByPage(name, page);

        Gson gson=new Gson();
        JsonArray roleListJa=gson.toJsonTree(roleList, List.class).getAsJsonArray();
        JsonObject resultJo=new JsonObject();
        resultJo.add("rows",roleListJa);
        resultJo.addProperty("total", total);


        return resultJo.toString();
    }

    /**
     * 更新角色
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateRole")
    public String updateRole(Role role){
        JsonObject resultJson=new JsonObject();
        if(roleService.findRoleDtoByRoleId(role.getId()).getName().equals(role.getName())==false){
            if(roleService.findRoleByRoleName(role.getName())>0){
                resultJson.addProperty("result",-2);
            }else {
                resultJson.addProperty("result", roleService.updateRole(role));
            }
        }else {
            resultJson.addProperty("result", roleService.updateRole(role));
        }
        return resultJson.toString();
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping("/addRole")
    public String addRole(Role role){
        JsonObject resultJson=new JsonObject();
        if(roleService.findRoleByRoleName(role.getName())>0){
            resultJson.addProperty("result",-2);
        }else {
            resultJson.addProperty("result", roleService.addRole(role));
        }
        return resultJson.toString();
    }

    /**
     * 根据角色id删除角色
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteRole")
    public String deleteRole(Integer roleId){
//		System.out.println(roleId);
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", roleService.deleteRoleById(roleId));
        return resultJson.toString();
    }

    /**
     * 为该角色分配权限
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/roleAssignAuthority")
    public String roleAssignAuthority(Integer id,Model model){
        List<Authority> authorities=authorityService.findAllAuthoritys();
        List<Integer> authorityIdList=roleAuthorityService.findAllAuthorityIdByRoleId(id);
        List<AuthorityDto> authorityDtoList=new ArrayList<AuthorityDto>();

        for(Authority authority:authorities){
            AuthorityDto authorityDto=new AuthorityDto();
            authorityDto.setId(authority.getId());
            authorityDto.setName(authority.getName());
            authorityDto.setCode(authority.getCode());
            authorityDto.setRemark(authority.getRemark());

            if(authorityIdList.contains(authority.getId())){
                authorityDto.setChecked(true);
            }
            authorityDtoList.add(authorityDto);

        }
        String authorityIds= ListUtil.integerListToString(authorityIdList);

        model.addAttribute("roleId", id);
        model.addAttribute("authorityList", authorityDtoList);
        model.addAttribute("authorityIds", authorityIds);

        return "user/roleAssignAuthorities";
    }

    /**
     * 更新角色的权限数据
     * @param roleId
     * @param authorityIds
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateRoleAuthority")
    public String updateRoleAuthority(Integer roleId,String authorityIds){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("success", authorityService.assignAuthority(roleId, authorityIds));

        return jsonObject.toString();
    }

    /**
     * 根据角色id查找角色信息
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRole")
    public String getRole(Integer roleId){
        RoleDto roleDto=roleService.findRoleDtoByRoleId(roleId);
        JsonObject resultJson = new JsonObject();
        Gson gson = new Gson();
        resultJson.add("role", gson.toJsonTree(roleDto));
        return resultJson.toString();
    }
}
