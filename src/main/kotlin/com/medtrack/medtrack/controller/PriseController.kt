package com.medtrack.medtrack.controller

import com.medtrack.medtrack.entity.Prise
import com.medtrack.medtrack.entity.PriseDTO
import com.medtrack.medtrack.service.PriseService
import com.medtrack.medtrack.repository.MedicamentRepository
import com.medtrack.medtrack.repository.PriseRepository
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/prises")
class PriseController(
    private val priseService: PriseService,
    private val priseRepository: PriseRepository,
    private val medicamentRepository: MedicamentRepository
) {

    @PostMapping("/add")
    fun ajouterPrise(@Valid @RequestBody dto: PriseDTO): String {
        val medicament = medicamentRepository.findById(dto.medicamentId).orElse(null)
        if (medicament == null) {
            return "aucun médicament trouvé avec l'id ${dto.medicamentId}"
        }
        val prise = Prise(
            heure = dto.heure,
            date = dto.date,
            medicament = medicament,
            patient = medicament.patient
        )
        priseRepository.save(prise)
        return "prise ajoutée pour le médicament '${medicament.nom}' du patient '${medicament.patient?.nom}'."
    }

    @GetMapping("/all")
    fun afficherToutesLesPrises(): List<Prise> {
        return priseService.afficherToutesLesPrises()
    }

    @GetMapping("/{id}")
    fun chercherPrise(@PathVariable id: Long): Prise? {
        return priseService.chercherPriseParId(id)
    }

    @PutMapping("/update")
    fun modifierPrise(@Valid @RequestBody prise: Prise): Prise {
        return priseService.modifierPrise(prise)
    }

    @DeleteMapping("/delete/{id}")
    fun supprimerPrise(@PathVariable id: Long) {
        priseService.supprimerPrise(id)
    }

    @PutMapping("/updateEtat")
    fun updateEtatPrise(@RequestParam priseId: Long, @RequestParam etat: Boolean): String {
        val prise = priseRepository.findById(priseId).orElse(null)
            ?: return "aucune prise trouvée avec l'id $priseId"
        prise.etat = etat
        priseRepository.save(prise)
        val etatTexte = if (etat) "effectuée " else "non effectuée "
        return "La prise du ${prise.date} à ${prise.heure} pour le médicament '${prise.medicament?.nom}' a été marquée comme $etatTexte."
    }

    @GetMapping("/oubliees/{patientId}/{medicamentId}")
    fun getPrisesOublieesParMedicament(
        @PathVariable patientId: Long,
        @PathVariable medicamentId: Long
    ): String {
        return priseService.prisesOublieesParMedicament(patientId, medicamentId)
    }
}
