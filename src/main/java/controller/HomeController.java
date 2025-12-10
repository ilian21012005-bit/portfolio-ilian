package com.ilian.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

// Classes internes simples pour structurer les données
record Project(String title, String description, String[] tags) {}
record Skill(String name, int level) {}
record Experience(String company, String role, String period, String description) {}

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // 1. Informations Personnelles
        model.addAttribute("name", "Ilian El Bouazzaoui Prieur");
        model.addAttribute("title", "Étudiant BUT Informatique - IUT Paris-Saclay");
        model.addAttribute("bio", "Passionné par le développement Java, le Web et l'Algorithmique. Je cherche à allier performance et innovation.");

        // 2. Compétences (Hard Skills)
        List<Skill> skills = Arrays.asList(
            new Skill("Java / Spring", 90),
            new Skill("HTML / CSS", 85),
            new Skill("SQL / Base de Données", 75),
            new Skill("C++ / Algorithmique", 80)
        );
        model.addAttribute("skills", skills);

        // 3. Projets (Basés sur ton PDF)
        List<Project> projects = Arrays.asList(
            new Project("Gestion Cité Internationale", 
                       "Application Java Swing complète avec modélisation UML. Gestion des résidents et événements.", 
                       [cite_start]new String[]{"Java", "Swing", "MVC", "Git"}), // [cite: 15-22]
            
            new Project("Algorithme de Groupes", 
                       "Outil d'optimisation pour la création automatique de groupes d'étudiants sous contraintes.", 
                       [cite_start]new String[]{"Java", "Algorithmique", "Optimisation"}), // [cite: 231-234]
            
            new Project("Jeu du Sentier", 
                       "Jeu développé en C++ avec une IA prenant des décisions aléatoires.", 
                       [cite_start]new String[]{"C++", "IA", "Logique"}) // [cite: 61-62]
        );
        model.addAttribute("projects", projects);

        // 4. Expériences
        List<Experience> experiences = Arrays.asList(
            [cite_start]new Experience("Boulanger", "Employé Polyvalent", "Été 2025", "Conseil client, gestion des stocks et SAV."), // [cite: 148-153]
            [cite_start]new Experience("Toyota France", "Chargé Relation Clientèle", "Été 2023", "Support technique et prévention des fraudes.") // [cite: 134-137]
        );
        model.addAttribute("experiences", experiences);

        return "index"; // Renvoie vers index.html
    }
}