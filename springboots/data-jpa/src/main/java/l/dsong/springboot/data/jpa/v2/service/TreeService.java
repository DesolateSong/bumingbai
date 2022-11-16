package l.dsong.springboot.data.jpa.v2.service;

import l.dsong.springboot.data.jpa.v2.entity.Tree;
import l.dsong.springboot.data.jpa.v2.repository.TreeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class TreeService {

    @Resource
    private TreeRepository treeRepository;

    public Tree save(Tree tree) {
        return treeRepository.save(tree);
    }

    public Tree get(Long id) {
        return treeRepository.getReferenceById(id);
    }

}
