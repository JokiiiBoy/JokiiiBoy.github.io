package com.jokiiboy.tracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrackerController {

    @PostMapping("/submit-tracker")
    public String handleTrackerSubmission(
            @RequestParam("task") String task,
            @RequestParam("mood") String mood,
            Model model) {

        // Logic processing based on user mood
        String encouragement;
        switch (mood) {
            case "Happy":
                encouragement = "Incredible! Keep riding that creative wave. 🌊";
                break;
            case "Focused":
                encouragement = "Absolute genius zone. You're unstoppable! 🧠✨";
                break;
            case "Tired":
                encouragement = "Make sure to take a break and get some hot cocoa. ☕";
                break;
            default:
                encouragement = "Keep coding cleanly! 💻";
        }

        // Print to backend console for debugging
        System.out.println("Log received! Task: " + task + " | Mood: " + mood);

        // Sending data back to the frontend template
        model.addAttribute("message", "Successfully logged your progress!");
        model.addAttribute("encouragement", encouragement);

        return "result-page"; // Loads the result page
    }
}
