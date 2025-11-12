package harjoitustyo.backend;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.backend.model.AppUser;
import harjoitustyo.backend.model.AppUserRepository;
import harjoitustyo.backend.model.Category;
import harjoitustyo.backend.model.CategoryRepository;
import harjoitustyo.backend.model.Recipe;
import harjoitustyo.backend.model.RecipeRepository;

@SpringBootApplication
public class BackendApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
    public CommandLineRunner demo(RecipeRepository recipeRepository, CategoryRepository categoryRepository, AppUserRepository appUserRepository) {
        return (args) -> {

            Category kakut = (new Category("kakut"));
            Category keksit = (new Category("keksit"));
            Category muffinit = (new Category("muffinit"));
            categoryRepository.save(kakut);
            categoryRepository.save(keksit);
            categoryRepository.save(muffinit);

            /* Ingredient kananmuna = (new Ingredient("kananmuna"));
            Ingredient vehnäjauho = (new Ingredient("vehnäjauho"));
            Ingredient perunajauho =(new Ingredient("perunajauho"));
            Ingredient suklaa =(new Ingredient("suklaa"));
            Ingredient voi =(new Ingredient("voi"));
            Ingredient sokeri = (new Ingredient("sokeri"));
            ingredientRepository.save(kananmuna);
            ingredientRepository.save(vehnäjauho);
            ingredientRepository.save(perunajauho);
            ingredientRepository.save(suklaa);
            ingredientRepository.save(voi);
            ingredientRepository.save(sokeri); */




            
			Recipe recipe1 = new Recipe("Suklaakakku", 20.0, "30min 175C", "200g voi, 4 kanamunaa, 3dl sokeri, 4dl vehnäjauho",
            "Sulata voi ja suklaa. Vatkaa munat ja sokeri vaahdoksi. Lisää jauhot ja voi-suklaasula.", kakut);
            recipeRepository.save(recipe1);
            Recipe recipe2 = new Recipe("Suklaakeksit", 15.0, "12min 200C", "100g voita, 1dl sokeria, 1 kananmuna, 2dl vehnäjauhoja, 100g suklaarouhetta",
            "Vatkaa voi ja sokeri. Lisää muna ja jauhot. Sekoita joukkoon suklaarouhe. Nostele taikinasta nokareita pellille ja paista 200°C noin 12 minuuttia.", keksit);
            recipeRepository.save(recipe2);
            Recipe recipe3 = new Recipe("Mustikkamuffinit",10.0,"20min 200C","2 munaa, 1dl sokeria, 2dl vehnäjauhoja, 1tl leivinjauhetta, 100g mustikoita, 1dl maitoa",
            "Vatkaa munat ja sokeri. Lisää maito, jauhot ja leivinjauhe. Sekoita kevyesti mustikat joukkoon. Paista 200°C noin 20 minuuttia.", muffinit);
            recipeRepository.save(recipe3);

        AppUser user1 = new AppUser("user", "$2a$10$eLf3Po94URHnCmbtn18umebWxwlRI8EGmDVVL29SA2jYEpOj5Nj8y", "USER");
		AppUser user2 = new AppUser("admin", "$2a$10$HRMMAe0D4CtENoiGP8vUBOnIdO.COE914FcewdFgZXkgbPB5vUbPm", "ADMIN");
		appUserRepository.save(user1);
		appUserRepository.save(user2);


            
        };
    }

}


