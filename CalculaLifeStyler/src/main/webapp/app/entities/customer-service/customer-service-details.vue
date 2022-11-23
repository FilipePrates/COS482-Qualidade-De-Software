<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="customerService">
        <h2 class="jh-entity-heading" data-cy="customerServiceDetailsHeading">
          <span v-text="$t('calculaLifeStylerApp.customerService.detail.title')">CustomerService</span> {{ customerService.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.name')">Name</span>
          </dt>
          <dd>
            <span>{{ customerService.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.serviceDate')">Service Date</span>
          </dt>
          <dd>
            <span>{{ customerService.serviceDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.customerName')">Customer Name</span>
          </dt>
          <dd>
            <span>{{ customerService.customerName }}</span>
          </dd>
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.employeeName')">Employee Name</span>
          </dt>
          <dd>
            <span>{{ customerService.employeeName }}</span>
          </dd>
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.customerSatisfaction')">Customer Satisfaction</span>
          </dt>
          <dd>
            <span>{{ customerService.customerSatisfaction }}</span>
          </dd>
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.orderDescription')">Order Description</span>
          </dt>
          <dd>
            <span>{{ customerService.orderDescription }}</span>
          </dd>
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.paymentValue')">Payment Value</span>
          </dt>
          <dd>
            <span>{{ customerService.paymentValue }}</span>
          </dd>
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.paymentDescription')">Payment Description</span>
          </dt>
          <dd>
            <span>{{ customerService.paymentDescription }}</span>
          </dd>
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.expenseValue')">Expense Value</span>
          </dt>
          <dd>
            <span>{{ customerService.expenseValue }}</span>
          </dd>
          <dt>
            <span v-text="$t('calculaLifeStylerApp.customerService.expenseDescription')">Expense Description</span>
          </dt>
          <dd>
            <span>{{ customerService.expenseDescription }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./customer-service-details.component.ts"></script>
