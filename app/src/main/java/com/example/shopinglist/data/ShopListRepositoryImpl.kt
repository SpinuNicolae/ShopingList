package com.example.shopinglist.data

import com.example.shopinglist.domain.ShopItem
import com.example.shopinglist.domain.ShopListRepository

object ShopListRepositoryImpl :ShopListRepository{

    private val shopList= mutableListOf<ShopItem>()
    private var auincrementId=0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id==ShopItem.UNDEFINED_ID) {
            shopItem.id = auincrementId
            auincrementId++
        }else
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
       val oldElement= getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id==shopItemId } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getList(): List<ShopItem> {
        return shopList.toList()
    }
}