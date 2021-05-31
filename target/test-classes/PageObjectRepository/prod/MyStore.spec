Element                 Locator Type         Locator
===================================================================================================
list_container    		css							div[class='product-image-container']
title_product			css					#layer_cart_product_title
btn_addToCart          css                  a[title="Add to cart"]
modal_cart				css					#layer_cart div[class*='layer_cart_cart']
btn_proceed            xpath                  //div[@id="layer_cart"]//span[contains(text(),"Proceed to checkout")]
btn_cartProceedCheckOut		xpath				//p[@class="cart_navigation clearfix"]//span[contains(text(),"${text}")]
checkout_tabs         xpath                  //ul[@id="order_step"]//span[contains(text(),"${text}")]
account_name           css                    .account span
orderDetails			xpath			//div[@id="center_column"]
option_payment                css                    .payment_module .${text}
details_order				xpath				//*[@id='order-list']/tbody/tr/td[1]/a
txtConfirm             css                     .box .cheque-indent .dark
btn_myOrders           css                     .myaccount-link-list [title=Orders]
order_date             xpath                    //table[@id="order-list"]/tbody/tr[1]/td[contains(@class,"history_date")]
order_ref1             css                      .box.order-confirmation
personal_info          css                      .myaccount-link-list [title=Information]
msg_success                 css                     .alert-success
btn_i_agree                css                    .checker input
