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
            Category piirakat = (new Category("piirakat"));
            categoryRepository.save(kakut);
            categoryRepository.save(keksit);
            categoryRepository.save(muffinit);
            categoryRepository.save(piirakat);

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
            Recipe recipe4 = new Recipe("Kaurakeksit", 10.0, "10min 200C", "100g voita, 1dl sokeria, 2dl kaurahiutaleita, 1dl vehnäjauhoja, 1tl leivinjauhetta, 1 kananmuna",
            "Sulata voi. Sekoita kaikki ainekset keskenään. Nostele lusikalla pellille ja paista 200 asteessa noin 10 minuuttia.", keksit);
            recipeRepository.save(recipe4);
            Recipe recipe5 = new Recipe("Sitruunakakku", 20.0, "40min 175C","200g voita, 2dl sokeria, 3 munaa, 3dl vehnäjauhoja, 2tl leivinjauhetta, 1 sitruunan mehu ja kuori",
            "Vaahdota voi ja sokeri. Lisää munat yksitellen. Sekoita kuivat aineet ja lisää joukkoon sitruunan mehu ja kuori. Kaada taikina vuokaan ja paista 175°C noin 40 minuuttia.", kakut);
            recipeRepository.save(recipe5);
            Recipe recipe6 = new Recipe("Pähkinäkeksit", 15.0, "12min 200C","100g voita, 1dl fariinisokeria, 1 kananmuna, 2dl vehnäjauhoja, 1dl rouhittuja pähkinöitä, 1tl vaniljasokeria",
            "Vaahdota voi ja sokeri. Lisää muna, sitten kuivat aineet ja pähkinät. Nostele taikinasta nokareita pellille ja paista 200°C noin 12 minuuttia.", keksit);
            recipeRepository.save(recipe6);
            Recipe recipe7 = new Recipe("Savulohipiirakka", 25.0, "30min 200C","125g voita, 3dl vehnäjauhoja, 2rkl vettä, 200g savulohta, 2dl kermaa, 2 munaa, tilliä, mustapippuria",
            "Tee taikina ja painele vuokaan. Lisää savulohi ja tilli. Sekoita munat ja kerma, mausta ja kaada täytteiden päälle. Paista 200°C noin 30 minuuttia.",piirakat);
            recipeRepository.save(recipe7);
            Recipe recipe8 = new Recipe("Mustikkapiirakka", 15.0, "30min 200C","100g voita, 1dl sokeria, 1 muna, 2dl vehnäjauhoja, 1tl leivinjauhetta, 2dl mustikoita, 1tl vaniljasokeria",
            "Vaahdota voi ja sokeri. Lisää muna, sekoita kuivat aineet ja lopuksi mustikat. Kaada vuokaan ja paista 200°C noin 30 minuuttia.",piirakat);
            recipeRepository.save(recipe8);
            Recipe recipe9 = new Recipe("Omenapiirakka", 15.0, "35min 200C","150g voita, 1dl sokeria, 1 muna, 3dl vehnäjauhoja, 1tl leivinjauhetta, 3 omenaa, 1tl kanelia, 2rkl sokeria",
            "Vaahdota voi ja sokeri. Lisää muna, sekoita kuivat aineet joukkoon. Levitä taikina vuokaan. Asettele ohuet omenaviipaleet päälle, ripottele sokeri ja kaneli. Paista 200°C noin 35 minuuttia, kunnes pinta on kauniin ruskea.",piirakat);
            recipeRepository.save(recipe9);


        AppUser user1 = new AppUser("user", "$2a$10$eLf3Po94URHnCmbtn18umebWxwlRI8EGmDVVL29SA2jYEpOj5Nj8y", "USER");
		AppUser user2 = new AppUser("admin", "$2a$10$HRMMAe0D4CtENoiGP8vUBOnIdO.COE914FcewdFgZXkgbPB5vUbPm", "ADMIN");
		appUserRepository.save(user1);
		appUserRepository.save(user2);


            
        };
    }

}


