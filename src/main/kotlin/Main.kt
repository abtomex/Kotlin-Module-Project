import model.Archive
import model.Note
import repo.ArchiveRepo
import repo.NoteRepo
import service.ConsoleManager

fun main() {

    initCollections()
    ConsoleManager.showContentWithNavigation()
}

fun initCollections() {
    val archive1 = Archive("Архив Димы")
    val archive2 = Archive("Архив Кати")
    val archive3 = Archive("Архив Артёма")

    ArchiveRepo.save(archive1)
    ArchiveRepo.save(archive2)
    ArchiveRepo.save(archive3)

    val note11 = Note("Заметка 1", "Это заметка о природе.")
    val note12 = Note("Заметка 2", "Это заметка о java.")
    val note13 = Note("Заметка 3", "Это заметка о путешествиях.")
    val note21 = Note("Заметка 1", "Это заметка о похудении.")
    val note31 = Note("Заметка 1", "Это заметка о школе.")
    val note32 = Note("Заметка 2", "Это заметка о друзьях.")

    NoteRepo.save(note11, archive1)
    NoteRepo.save(note12, archive1)
    NoteRepo.save(note13, archive1)
    NoteRepo.save(note21, archive2)
    NoteRepo.save(note31, archive3)
    NoteRepo.save(note32, archive3)

}
