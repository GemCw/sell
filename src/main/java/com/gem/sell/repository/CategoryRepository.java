package com.gem.sell.repository;

import com.gem.sell.dataobject.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 39726
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    List<Category> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
