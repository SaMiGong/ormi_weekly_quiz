package ormi.storywave.weekly_quiz4;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
  private final MenuRepository menuRepository;

  public MenuService(MenuRepository menuRepository) {
    this.menuRepository = menuRepository;
  }

  // 모든 메뉴를 조회하는 메서드
  public List<Menu> getAllMenus() {
    return menuRepository.findAll();
  }

  // ID로 메뉴를 조회하는 메서드
  public Menu getMenuById(Long id) {
    return menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));
  }

  // 새로운 메뉴를 생성하는 메서드
  public Menu createMenu(Menu menu) {
    return menuRepository.save(menu);
  }

  // 기존 메뉴를 수정하는 메서드
  public Menu updateMenu(Long id, Menu updatedMenu) {
    Menu existingMenu =
        menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));
    existingMenu.setName(updatedMenu.getName());
    existingMenu.setCategory(updatedMenu.getCategory());
    existingMenu.setPrice(updatedMenu.getPrice());
    existingMenu.setDescription(updatedMenu.getDescription());
    return menuRepository.save(existingMenu);
  }

  // 메뉴를 삭제하는 메서드
  public void deleteMenu(Long id) {
    menuRepository.deleteById(id);
  }
}
