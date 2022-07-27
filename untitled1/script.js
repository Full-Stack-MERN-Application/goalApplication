const fileData = [];

const options = {
	method: 'GET',
	headers: {
        'Content-Type': 'application/json',
		"apiKey": `${NGPVANCREDS}`
	},
};

function emailData (emailId) {
	return fetch(`https://api.myngp.com/v2/broadcastEmails/${emailId}?$expand=statistics`, options);
}

function allEmails () {
	return fetch('https://api.myngp.com/v2/broadcastEmails', options)
		.then(res => res.json())
}

allEmails().then(res => {
	res.items.forEach((email, index) => {
		emailData(email.emailMessageId)
			.then(res => res.json())
			.then(email => {
				let obj = {
					Id: `${email.emailMessageId}`,
					'Email Name': `${email.name}`,
					Recipients: `${email.statistics.recipients}`,
					Bounces: `${email.statistics.bounces}`,
					Clicks: `${email.statistics.clicks}`,
					Opens: `${email.statistics.opens}`,
					Unsubscribes: email.statistics.unsubscribes,
				}
				if (index === 0 ) {
					console.log(findVariant(email.emailMessageId, email.variants))
				}

				fileData.push(obj)
			})
	})
})

function findVariant(emailId, variants) {
	let variantName;
	let variantOpen = 0
	variants.forEach(email => {
		fetch(`https://api.myngp.com/v2/broadcastEmails/${emailId}/variants/${email.emailMessageVariantId}?$expand=statistics`, options)
			.then(response => response.json())
			.then(response => {
				if (variantOpen <= response.statistics.opens ) {
					console.log(response.statistics.opens)
					variantOpen = response.statistics.opens
					variantName = response.name
				}
			})
			.catch(err => console.error(err));
		console.log(variantName)
	})
}
console.log(fileData)
