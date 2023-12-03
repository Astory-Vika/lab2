package com.example.task1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arrayOf(
            MainItem(
                "https://artworks.thetvdb.com/banners/movies/66/posters/5ecacb306a644.jpg",
                "Harry Potter and the Philosopher's Stone",
                "An orphaned boy named Harry Potter discovers on his 11th birthday, that his " +
                        "deceased parents were powerful wizards and that he has been invited to attend " +
                        "the esteemed and mysterious Hogwarts School of Witchcraft and Wizardry, which " +
                        "opens up a world of wonders for young Harry.",
                2001
            ),
            MainItem(
                "https://artworks.thetvdb.com/banners/movies/63/posters/5ebb0c57951c9.jpg",
                "Harry Potter and the Chamber of Secrets",
                "Harry Potter's unfortunate summer away from his friends continues " +
                        "when he returns to school and an ancient prophecy seems to be coming true as a " +
                        "mysterious presence stalks the corridors at Hogwarts, leaving its victims paralyzed.",
                2002
            ),
            MainItem(
                "https://artworks.thetvdb.com/banners/v4/movie/154/posters/60b8ed0117995.jpg",
                "Harry Potter and the Prisoner of Azkaban",
                "Harry Potter, after spending another dissatisfying summer with The Dursleys, " +
                        "returns to Hogwarts ready to train and study. " +
                        "However, when Harry and classmates delve into the mystery surrounding an " +
                        "escaped prisoner, they realize that he may pose a serious threat to the young wizard.",
                2004
            ),
            MainItem(
                "https://artworks.thetvdb.com/banners/movies/153/posters/153.jpg",
                "Harry Potter and the Goblet of Fire",
                "Harry Potter finds himself competing in a hazardous tournament between rival" +
                        "schools of magic, but he is distracted by recurring nightmares.",
                2005
            ),
            MainItem(
                "https://artworks.thetvdb.com/banners/movies/128/posters/128.jpg",
                "Harry Potter and the Order of the Phoenix",
                "Returning for his fifth year of study at Hogwarts, Harry is stunned to find " +
                        "that his warnings about the return of Lord Voldemort have been ignored. " +
                        "Left with no choice, Harry takes matters into his own hands, training a small " +
                        "group of students – dubbed 'Dumbledore's Army' – to defend themselves " +
                        "against the dark arts.",
                2007
            ),
            MainItem(
                "https://artworks.thetvdb.com/banners/movies/201/posters/2198531.jpg",
                "Harry Potter and the Deathly Hallows: Part 1",
                "As Harry, Ron, and Hermione race against time and evil to destroy the Horcruxes, " +
                        "they uncover the existence of the three most powerful objects in the wizarding " +
                        "world: the Deathly Hallows.",
                2010
            ),
            MainItem(
                "https://artworks.thetvdb.com/banners/movies/142/posters/5ebb0ee946958.jpg",
                "Harry Potter and the Deathly Hallows: Part 2",
                "The stakes have never been higher, and no one is safe as the battle between " +
                        "the good and evil forces of the wizarding world escalates into an all-out war. " +
                        "But it is Harry Potter who may be called upon to make the ultimate sacrifice as " +
                        "he draws closer to the climactic showdown with Lord Voldemort. It all ends here.",
                2011
            ),
        )

        val navController = findNavController()
        val adapter = MainAdapter(items) {
            navController.navigate(
                R.id.action_main_to_detailsFragment, DetailsFragment.prepareBundle(
                    it.image,
                    it.title,
                    it.description,
                    it.year
                )
            )
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.adapter = adapter
    }
}