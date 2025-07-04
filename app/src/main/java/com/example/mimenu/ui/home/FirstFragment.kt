package com.example.mimenu.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.mimenu.R
import com.example.mimenu.data.AppDataBase
import com.example.mimenu.data.Entities.BannerEntity
import com.example.mimenu.data.Entities.FoodEntity
import com.example.mimenu.data.Entities.OrderEntity
import com.example.mimenu.data.Entities.VoucherEntity
import com.example.mimenu.databinding.FragmentFirstBinding
import com.example.mimenu.view_model.FoodViewModel
import me.relex.circleindicator.CircleIndicator3
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FirstFragment : Fragment(), OnClickHome {

    private lateinit var binding : FragmentFirstBinding
    private val foodViewModel by viewModels<FoodViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        setupDiscountRecycler()
        setupVoucherRecycler()
    }
    private fun setupViewPager(){
        val adapter = BannerAdapter(getBanner())
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }
    private fun getBanner() : List<BannerEntity>{
        val bannerList = listOf(
            BannerEntity(1,R.mipmap.b44,"Banner 1" ),
            BannerEntity(2,R.mipmap.b2,"Banner 2" ),
            BannerEntity(3,R.mipmap.b33,"Banner 3" ),
            BannerEntity(4,R.mipmap.b1,"Banner 2" )
            )
        return bannerList
    }
    private fun setupDiscountRecycler(){
        val adapter = DiscountAdapter(foodViewModel.getOffer, this)
        binding.rvDiscountHome.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvDiscountHome.adapter = adapter
    }
    override fun onClickDiscount(food: FoodEntity) {
        val order = OrderEntity(name= food.name, description = food.description, price = food.price, img = food.img, priceTotal = food.price, quantity = 1, discount = food.discount)
        val action = FirstFragmentDirections.actionFirstFragmentToFoodDetailFragment(order,3)
        findNavController().navigate(action)
    }

    override fun onClickVoucher(voucher: VoucherEntity) {
        val action = FirstFragmentDirections.actionFirstFragmentToVocuherDetailFragment(voucher)
        findNavController().navigate(action)
    }

    private fun setupVoucherRecycler(){
        val adapter = VoucherAdapter(getAllVoucher(), this)
        binding.rvVoucherHome.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvVoucherHome.adapter =adapter
    }
    private fun getAllVoucher() : List<VoucherEntity>{
        return listOf(
            VoucherEntity(
                id = 1,
                name = "Combo Mega Doble Big Bang + Sundae",
                description = "Pedí la Mega Doble Big Bang y te llevás un Sundae gratis. Ideal para campeones del hambre.",
                img = R.mipmap.co2,
                code = "54-2353-1646",
                expiration = stringToLocalDate("10/08/2025"),
                category = "Las + poderosas"
            ),
            VoucherEntity(
                id = 2,
                name = "Epica Huevo + Cuarto XL",
                description = "Combo de poder con dos hamburguesas icónicas. 35% OFF solo por tiempo limitado.",
                img = R.mipmap.co2,
                code = "78-8472-1023",
                expiration = stringToLocalDate("15/08/2025"),
                category = "Las + poderosas"
            ),
            VoucherEntity(
                id = 3,
                name = "Big Bang Cheddar + Bebida + Sundae",
                description = "El trío legendario con 40% de descuento. ¿Vas a resistirte?",
                img = R.mipmap.co1,
                code = "61-9294-3847",
                expiration = stringToLocalDate("20/08/2025"),
                category = "Las + poderosas"
            ),
            VoucherEntity(
                id = 4,
                name = "2 Combos Doble Cuarto XL",
                description = "Ideal para dos. Incluye 2 hamburguesas, 2 papas y 2 bebidas. A solo $14500.",
                img = R.mipmap.co1,
                code = "73-1846-5821",
                expiration = stringToLocalDate("10/09/2025"),
                category = "Para compartir"
            ),
            VoucherEntity(
                id = 5,
                name = "Combo Dulce x2 + Café",
                description = "2 medialunas rellenas + 2 cafés. Compartí una mañana feliz.",
                img = R.mipmap.h3,
                code = "84-9247-1172",
                expiration = stringToLocalDate("10/09/2025"),
                category = "Para compartir"
            ),
            VoucherEntity(
                id = 6,
                name = "Sundae x3 Pack",
                description = "El pack perfecto para amigos dulceros. Elegí 3 sundaes a elección por $6900.",
                img = R.mipmap.h1,
                code = "66-3939-1029",
                expiration = stringToLocalDate("20/10/2025"),
                category = "Para compartir"
            ),
            VoucherEntity(
                id = 7,
                name = "Café + 2 Medialunas rellenas",
                description = "Combo especial dulce por la tarde. Con 15% de descuento.",
                img = R.mipmap.h3,
                code = "35-4821-3991",
                expiration = stringToLocalDate("12/09/2025"),
                category = "Algo dulce"
            ),
            VoucherEntity(
                id = 8,
                name = "Sundae + Medialuna",
                description = "¿Dulce sobre dulce? Helado y medialuna por solo $3100.",
                img = R.mipmap.h1,
                code = "49-2783-8872",
                expiration = stringToLocalDate("18/09/2025"),
                category = "Algo dulce"
            ),
            VoucherEntity(
                id = 9,
                name = "Café con medialuna gratis",
                description = "Comprás un café y te llevás una medialuna sin costo. Porque sí.",
                img = R.mipmap.h3,
                code = "58-3021-0042",
                expiration = stringToLocalDate("25/09/2025"),
                category = "Algo dulce"
            )
        )

    }
    fun stringToLocalDate(date : String) : LocalDate{
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyy")
        return LocalDate.parse(date,formatter)
    }
}
