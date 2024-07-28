package ormi.storywave.weekly_quiz4;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }
    // 모든 메뉴를 조회하는 엔드포인트
    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    // ID로 특정 메뉴를 조회하는 엔드포인트
    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    // 새로운 메뉴를 생성하는 엔드포인트
    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.createMenu(menu);
    }

    // 기존 메뉴를 수정하는 엔드포인트
    @PutMapping("/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
        return menuService.updateMenu(id, menu);
    }

    // 메뉴를 삭제하는 엔드포인트
    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}
