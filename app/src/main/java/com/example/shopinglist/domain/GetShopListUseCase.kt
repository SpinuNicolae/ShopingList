package com.example.shopinglist.domain

class GetShopListUseCase (private val shopListRepository: ShopListRepository){
    fun getList(): List<ShopItem> {
        return shopListRepository.getList()
    }
}