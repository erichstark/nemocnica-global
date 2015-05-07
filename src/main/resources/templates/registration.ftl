<#-- @ftlvariable name="patient" type="sk.stuba.fei.team.local.domain.Patient" -->
<#import "lib/pageTemplates.ftl" as g>
<#import "/spring.ftl" as spring>
<#assign pageTitle in g><@spring.message "Registration"/></#assign>
<@g.genericPage>
<div class="container">
	<div id="registration-panel" class="panel panel-default">
		<div class="panel-heading"><h3 class="panel-title"><strong>Registrácia</strong></h3></div>
		<div class="panel-body">
			<form role="form" action="<@spring.url '/registration/save'/>" method="post">
				<div class="row">
					<div class="form-group col-md-6 col-xs-6 col-sm-6">
						<label for="prefix-title"><@spring.message "PrefixTitle"/></label>
						<input type="text" class="form-control" id="prefix-title" name="prefix_title"
								value="${ patient.prefix_title }">
					</div>
					<div class="form-group col-md-6 col-xs-6 col-sm-6">
						<label for="suffix-title"><@spring.message "SuffixTitle"/></label>
						<input type="text" class="form-control" id="suffix-title" name="suffix_title"
								value="${ patient.suffix_title }">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label for="given-name" class="required"><@spring.message "GivenName"/></label>
						<input type="text" class="form-control" id="given-name" name="firstName"
								value="${ patient.firstName }" required>
					</div>
					<div class="form-group col-md-6">
						<label for="family-name" class="required"><@spring.message "FamilyName"/></label>
						<input type="text" class="form-control" id="family-name" name="surname"
								value="${ patient.surname }" required>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label for="phone-number"><@spring.message "PhoneNumber"/></label>
						<input type="text" class="form-control" id="phone-number" name="phone"
								value="${ patient.phone }">
					</div>
					<div class="form-group col-md-6">
						<label for="email" class="required"><@spring.message "Email"/></label>
						<input type="email" class="form-control" id="email" name="email"
								value="${ patient.email }" required>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label for="insurance"><@spring.message "Insurance"/></label>
						<input type="text" class="form-control" id="insurance" name="insurance">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label for="username" class="required"><@spring.message "Username"/></label>
						<input type="text" class="form-control" id="username" name="username"
								value="${ patient.username }" required>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label for="password" class="required"><@spring.message "Password"/></label>
						<input type="password" class="form-control" id="password" name="password"
								value="${ patient.password }" required>
					</div>
					<div class="form-group col-md-6">
						<label for="password-repeat" class="required">Heslo znovu</label>
						<input type="password" class="form-control" id="password-repeat" name="password-repeat" required>
					</div>
				</div>
				<button type="submit" class="btn btn-sm btn-default btn-custom" id="reg-button">Registrovať</button>
			</form>
		</div>
	</div>
</div>
</@g.genericPage>