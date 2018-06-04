package ie.pennylabs.x.basil.feature.recipe.detail.instructions

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.toolbox.extension.doOnTabReselected
import ie.pennylabs.x.basil.toolbox.extension.doOnTabSelected
import ie.pennylabs.x.basil.toolbox.extension.expand
import kotlinx.android.synthetic.main.bottom_sheet_recipe_instructions.view.*

class RecipeInstructionsBottomSheet : ConstraintLayout {
  val bottomSheet: BottomSheetBehavior<RecipeInstructionsBottomSheet> by lazy { BottomSheetBehavior.from(this) }
  var recipeId: String = ""
    set(value) {
      pager.adapter = RecipeInstructionsPagerAdapter(value)
      bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
    }

  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    LayoutInflater.from(context).inflate(R.layout.bottom_sheet_recipe_instructions, this, true)

    pager.apply {
      pagerTabs.setupWithViewPager(this)
      adapter = RecipeInstructionsPagerAdapter(recipeId)
    }
    pagerTabs.doOnTabReselected { bottomSheet.expand() }
    pagerTabs.doOnTabSelected { bottomSheet.expand() }
  }
}