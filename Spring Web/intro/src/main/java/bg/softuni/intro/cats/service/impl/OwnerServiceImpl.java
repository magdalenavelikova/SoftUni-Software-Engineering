package bg.softuni.intro.cats.service.impl;

import bg.softuni.intro.cats.model.dto.CreateOwnerDTO;
import bg.softuni.intro.cats.model.entity.CatEntity;
import bg.softuni.intro.cats.model.entity.OwnerEntity;
import bg.softuni.intro.cats.repository.OwnerRepository;
import bg.softuni.intro.cats.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

  private OwnerRepository ownerRepository;

  public OwnerServiceImpl(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public void createOwner(CreateOwnerDTO createOwnerDTO) {

    OwnerEntity owner = new OwnerEntity().
        setOwnerName(createOwnerDTO.getOwnerName());

    createOwnerDTO.getCatNames().
        forEach(name -> {
          CatEntity cat = new CatEntity().
              setCatName(name).
              setOwner(owner);
          owner.addCat(cat);
        });

    ownerRepository.save(owner);
  }
}
