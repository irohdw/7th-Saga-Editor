package application.models.lists

import application.models.Spell
import java.io.Serializable

class Spells : Models<Spell>, Serializable
{

	constructor() : super()
	constructor(addFrom: Spells, keepEmptyModel: Boolean) : super(addFrom, keepEmptyModel)

	override fun initialize(models: ModelsList<Spell>)
	{
		for (i in 0..spellListSize - 1)
		{
			val s = Spell(i)
			s.getValuesFromROM()
			models.add(s)
		}
	}

	override fun saveModels() = models.forEach { it.writeValuesToROM() }

	companion object
	{
		private val spellListSize = 61
	}
}
