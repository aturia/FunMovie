package com.example.funmovie.model

data class MovieItem(
    var id: String,
    var title: String,
    var content: String
) {
   companion object {
       fun createDummyMovieItem(): List<MovieItem> {
           val content1 = "A man is struggling to mourn his passing wife in this " +
                   "slow-burning Icelandic drama. The story starts with him converting an " +
                   "abandoned electricity station into a house, in an effort to find peace. " +
                   "Soon, however, questions about a possible extramarital affair that his wife disturb " +
                   "this peace and make it seem unattainable. "
           val content2 = "Adapted from the Lionel Shriver novel of the same name, We Need to " +
                   "Talk About Kevin is the story of a mother (Tilda Swinton) that never quite " +
                   "bonds with her child, but not by her choice. The son grows up to do a heinous" +
                   " act that begs the question: nature or nurture? This film is an uncompromising " +
                   "view on the development of an unloved child. Silent pain gets voice. Feelings are" +
                   " shown by actions not emotions in an authentic, comprehensible and aesthetic manner." +
                   " Great work."
           val content3 = "In “Lean on Pete,” Buscemi plays a guy called Del Montgomery (of course), " +
                   "who is a racetrack horse owner in Portland, Oregon. He befriends a kid, Charley " +
                   "(Charlie Plummer in an amazing performance), who had been abandoned by his family and is " +
                   "new to Portland. Together they take care of Montgomery’s only horse, until the kid discovers" +
                   " that the horse is set to be slaughtered. He embarks on an impossible journey across the U.S. " +
                   "to try to save the horse while also looking for his family. \n" +
                   "\n" +
                   "This movie flew under most peoples’ radars. It is truly amazing." +
                   " If you like “Lean on Pete” you should watch other A24 gems like" +
                   " “Lady Bird” or “The Florida Project.”"

           return listOf(
               MovieItem("1","A White, White Day (2020)",content1),
               MovieItem("1","We Need to Talk About Kevin (2012)",content2),
               MovieItem("1","Lean on Pete",content3)
           )
       }
   }
}